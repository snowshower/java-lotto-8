package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class OutputView {
    private final List<LottoRank> ranksDisplay = List.of(LottoRank.FIFTH, LottoRank.FOURTH,
            LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST);

    public OutputView() {
    }

    public void printPurchaseAmount(long count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoResult(Map<LottoRank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank lottoRank : ranksDisplay) {
            String description = lottoRank.getDescription();
            long prize = lottoRank.getPrizeAmount();
            int count = result.getOrDefault(lottoRank, 0);
            System.out.printf("%s (%,d원) - %d개\n", description, prize, count);
        }
    }

    public void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.printf("총 수익률은 %.1f%%입니다.", lottoStatistics.getYield());
    }
}
