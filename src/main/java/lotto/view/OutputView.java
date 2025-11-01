package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class OutputView {
    private final int purchaseAmount;
    private final Lottos lottos;
    private final Map<LottoRank, Integer> resultNumbers;
    private final LottoStatistics lottoStatistics;
    private final List<LottoRank> ranksDisplay = List.of(LottoRank.FIFTH, LottoRank.FOURTH,
            LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);

    public OutputView(int purchaseAmount, Lottos lottos,
                      Map<LottoRank, Integer> resultNumbers, LottoStatistics lottoStatistics) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = lottos;
        this.resultNumbers = resultNumbers;
        this.lottoStatistics = lottoStatistics;
    }

    public void printPurchaseAmount() {
        System.out.println(purchaseAmount + "개를 구매했습니다.");
    }

    public void printLottos() {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank lottoRank : ranksDisplay) {
            String description = lottoRank.getDescription();
            long prize = lottoRank.getPrizeAmount();
            int count = this.resultNumbers.getOrDefault(lottoRank, 0);
            System.out.printf("%s (%,d원) - %d개\n", description, prize, count);
        }
    }

    public void printLottoStatistics() {
        double statistics = lottoStatistics.getYield();
        System.out.printf("총 수익률은 %.1f%%입니다.", statistics);
    }
}
