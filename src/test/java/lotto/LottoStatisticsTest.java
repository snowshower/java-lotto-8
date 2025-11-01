package lotto;

import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;
import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.within;

public class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;
    private PurchaseAmount purchaseAmount;

    @BeforeEach
    void setUp(){
        Map<LottoRank, Integer> testLottos = new EnumMap<>(LottoRank.class);
        testLottos.put(LottoRank.FOURTH, 1);    //50000원
        testLottos.put(LottoRank.FIFTH, 1);     //5000원

        purchaseAmount = new PurchaseAmount(2000L);

        lottoStatistics = new LottoStatistics(purchaseAmount, testLottos);
    }


    @Test
    @DisplayName("당첨 금액의 합을 올바르게 반환한다")
    void 당첨_금액의_합을_올바르게_반환한다() {
        assertThat(lottoStatistics.getTotalPrizeMoney()).isEqualTo(55000L);
    }

    @Test
    @DisplayName("수익률을 올바르게 계산한다")
    void 수익률을_올바르게_계산한다() {
        assertThat(lottoStatistics.getYield()).isCloseTo(2750.0, within(0.01));
    }
}
