package bunsan.returnz.domain.game.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import reactor.util.annotation.Nullable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomMessageDto {
	private MessageType type;
	private String roomId;
	private Map<String, Object> messageBody;
	public enum MessageType {
		ENTER, READY, TURN, CHAT, END, @JsonEnumDefaultValue UNKNOWN;
	}
}
