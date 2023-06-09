package bunsan.returnz.domain.game.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bunsan.returnz.domain.game.dto.GameRoomDto;
import bunsan.returnz.global.advice.exception.BadRequestException;
import bunsan.returnz.global.advice.exception.NotFoundException;
import bunsan.returnz.persist.entity.GameRoom;
import bunsan.returnz.persist.repository.GameRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class GameRoomService {

	private final GameRoomRepository gameRoomRepository;

	public GameRoomDto findByRoomId(String roomId) {
		Optional<GameRoom> optionalGameRoom = gameRoomRepository.findByRoomId(roomId);

		// TODO: gameRoom이 비어있을 때 에러 반환 / 또는 개수가 적은 경우
		// if(gameRoom.isEmpty())
		GameRoom gameRoom = new GameRoom();

		return optionalGameRoom.map(gameRoom::toDto)
			.orElseThrow(() -> new BadRequestException("findByRoomId : 게임 방을 찾을 수 없습니다."));
	}

	public boolean updateGameTurn(LocalDateTime curDate, LocalDateTime nextCurDate, String roomId) {
		Optional<GameRoom> optionalGameRoom = gameRoomRepository.findByRoomId(roomId);

		optionalGameRoom.map(gameRoom -> gameRoom.updateGameTurn(curDate, nextCurDate))
			.orElseThrow(() -> new NotFoundException(""));
		gameRoomRepository.save(optionalGameRoom.orElseThrow(() -> new BadRequestException("")));
		return true;
	}

	public GameRoom findById(Long id) {
		Optional<GameRoom> optionalGameRoom = gameRoomRepository.findById(id);
		return optionalGameRoom.orElse(null);
	}
}
