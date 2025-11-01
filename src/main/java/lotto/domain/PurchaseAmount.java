package lotto.domain;

public class PurchaseAmount {
    private final long purchaseAmount;
    private static final long LOTTO_PRICE = 1000;

    public PurchaseAmount(long purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    //로또 몇 장인지 계산
    public long calculateLottoTickets(){
        return purchaseAmount / LOTTO_PRICE;
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }
}
