package lotto.dto;

public class PurchaseAmount {
    private final int purchaseAmount;
    private static final int LOTTO_PRICE = 1000;

    public PurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    //로또 몇 장인지 계산
    public int calculateLottoTickets(){
        return purchaseAmount / LOTTO_PRICE;
    }
}
