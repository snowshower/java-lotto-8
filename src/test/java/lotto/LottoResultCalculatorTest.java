package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResultCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultCalculatorTest {
    private final Lotto resultLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    private final BonusNumber bonusNumber = new BonusNumber(7);

    @DisplayName("당첨 결과를 올바르게 판단한다")
    @Test
    void 당첨_번호와_로또_번호_6개가_일치한다(){
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        LottoRank actualRank = LottoResultCalculator.lottoResultCalculate(resultLotto, firstLotto, bonusNumber);
        assertThat(actualRank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 당첨_번호와_로또_번호_5개가_일치하고_보너스_번호가_일치한다(){
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        LottoRank actualRank = LottoResultCalculator.lottoResultCalculate(resultLotto, secondLotto, bonusNumber);
        assertThat(actualRank).isEqualTo(LottoRank.SECOND);
    }

    @Test
    void 당첨_번호와_로또_번호_5개가_일치한다(){
        Lotto thirdLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        LottoRank actualRank = LottoResultCalculator.lottoResultCalculate(resultLotto, thirdLotto, bonusNumber);
        assertThat(actualRank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void 당첨_번호와_로또_번호_4개가_일치한다(){
        Lotto fourthLotto = new Lotto(List.of(1, 2, 3, 4, 9, 10));

        LottoRank actualRank = LottoResultCalculator.lottoResultCalculate(resultLotto, fourthLotto, bonusNumber);
        assertThat(actualRank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void 당첨_번호와_로또_번호_3개가_일치한다(){
        Lotto fifthLotto = new Lotto(List.of(1, 2, 3, 9, 10, 11));

        LottoRank actualRank = LottoResultCalculator.lottoResultCalculate(resultLotto, fifthLotto, bonusNumber);
        assertThat(actualRank).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void 당첨되지_않았다(){
        Lotto missLotto = new Lotto(List.of(1, 2, 9, 10, 11, 12));

        LottoRank actualRank = LottoResultCalculator.lottoResultCalculate(resultLotto, missLotto, bonusNumber);
        assertThat(actualRank).isEqualTo(LottoRank.MISS);
    }
}
