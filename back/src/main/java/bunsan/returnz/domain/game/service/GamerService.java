package bunsan.returnz.domain.game.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bunsan.returnz.domain.game.dto.GameGamerDto;
import bunsan.returnz.persist.entity.Gamer;
import bunsan.returnz.persist.repository.GamerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class GamerService {
	private final GamerRepository gamerRepository;

	public List<GameGamerDto> findAllByGameRoomId(Long id) {
		List<Gamer> gamerList = gamerRepository.findAllByGameRoomId(id);
		// TODO: gamerList가 empty면 에러 발생
		// if(gamerList.isEmpty())

		Gamer gamer = new Gamer();
		List<GameGamerDto> gameGamerDtos = new ArrayList<>();
		for (int i = 0; i < gamerList.size(); ++i) {
			gameGamerDtos.add(gamer.toDto(gamerList.get(i)));
		}
		return gameGamerDtos;
	}

	public GameGamerDto findById(Long gamerId) {
		Optional<Gamer> gamerOptional = gamerRepository.findById(gamerId);
		if (gamerOptional.isPresent()) {
			Gamer game = new Gamer();
			return game.toDto(gamerOptional.get());
		}
		// TODO : else
		return null;
	}

	public boolean updateDeposit(Long gamerId, Integer changeDeposit) {
		Optional<Gamer> gamerOptional = gamerRepository.findById(gamerId);
		if (gamerOptional.isPresent()) {
			if (changeDeposit >= 0) {
				Gamer gamer = gamerOptional.get();
				return gamer.updateDeposit(changeDeposit);
			}
		}
		return false;
	}
}
