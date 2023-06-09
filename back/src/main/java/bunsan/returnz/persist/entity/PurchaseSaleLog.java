package bunsan.returnz.persist.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import bunsan.returnz.domain.game.dto.PurchaseSaleLogDto;
import bunsan.returnz.domain.result.dto.PurchaseSaleLogResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseSaleLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PURCHASE_SALE_LOG_ID")
	private Long id;

	private Integer curTurn;    // 매수, 매도를 한 턴
	private Integer totalTurn;    // 해당 게임의 전체 턴
	private String companyCode;    // 매수, 매도를 한 종목 코드
	private String companyName;    // 매수, 매도를 한 종목 이름
	private LocalDateTime date; //  매수, 매도를 한 날짜
	private Integer category; // 매수 : 0, 매도 : 1
	private Integer count; // 매수, 매도한 종목의 수
	private Integer price;    // 매수, 매도한 종목의 가격

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GAME_ROOM_ID")
	private GameRoom gameRoom;    // 해당하는 게임 룸

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBER_ID")
	private Member member;    // 해당하는 게임 룸

	public boolean updateDto(PurchaseSaleLogDto purcahseSaleLogDto) {
		this.curTurn = purcahseSaleLogDto.getCurTurn();
		this.totalTurn = purcahseSaleLogDto.getTotalTurn();
		this.companyCode = purcahseSaleLogDto.getCompanyCode();
		this.companyName = purcahseSaleLogDto.getCompanyName();
		this.date = purcahseSaleLogDto.getDate();
		this.category = purcahseSaleLogDto.getCategory();
		this.count = purcahseSaleLogDto.getCount();
		this.price = purcahseSaleLogDto.getPrice();
		this.gameRoom = purcahseSaleLogDto.getGameRoom();
		this.member = purcahseSaleLogDto.getMember();
		return true;
	}

	public PurchaseSaleLogDto toDto(PurchaseSaleLog purchaseSaleLog) {
		return PurchaseSaleLogDto.builder()
			.curTurn(purchaseSaleLog.getCurTurn())
			.totalTurn(purchaseSaleLog.getTotalTurn())
			.companyCode(purchaseSaleLog.getCompanyCode())
			.companyName(purchaseSaleLog.getCompanyName())
			.date(purchaseSaleLog.getDate())
			.category(purchaseSaleLog.getCategory())
			.count(purchaseSaleLog.getCount())
			.price(purchaseSaleLog.getPrice())
			.gameRoom(purchaseSaleLog.getGameRoom())
			.member(purchaseSaleLog.getMember())
			.build();
	}

	public PurchaseSaleLogResponseDto toResponseDto(PurchaseSaleLog purchaseSaleLog) {
		return PurchaseSaleLogResponseDto.builder()
			.curTurn(purchaseSaleLog.getCurTurn())
			.totalTurn(purchaseSaleLog.getTotalTurn())
			.companyCode(purchaseSaleLog.getCompanyCode())
			.companyName(purchaseSaleLog.getCompanyName())
			.date(purchaseSaleLog.getDate())
			.category(purchaseSaleLog.getCategory())
			.count(purchaseSaleLog.getCount())
			.price(purchaseSaleLog.getPrice())
			.build();
	}
}
