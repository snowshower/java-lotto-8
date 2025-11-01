package lotto.domain;

import java.util.Map;

public class LottoStatistics {

    private final PurchaseAmount purchaseAmount;
    private final Map<LottoRank, Integer> rankCounts;

    public LottoStatistics(PurchaseAmount purchaseAmount, Map<LottoRank, Integer> rankCounts) {
        this.purchaseAmount = purchaseAmount;
        this.rankCounts = rankCounts;
    }

    public long getTotalPrizeMoney(){
        long totalPrizeMoney = 0L;
        for (LottoRank lottoRank : this.rankCounts.keySet()) {
            int count=rankCounts.get(lottoRank);
            long prize=lottoRank.getPrizeAmount();
            totalPrizeMoney += (count * prize);
        }
        return totalPrizeMoney;
    }

    public double getYield(){
        long totalPrizeMoney = getTotalPrizeMoney();
        if (purchaseAmount.getPurchaseAmount() == 0) {
            return 0.0;
        }

        return ((double) totalPrizeMoney / purchaseAmount.getPurchaseAmount()) * 100.0;
    }

}
