package lotto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

public class LottosTest {

    @Test
    @DisplayName("Lottos가 로또 목록을 보관하는지 확인")
    void 로또_목록_보관을_확인한다(){
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        Lotto thirdLotto = new Lotto(List.of(13, 14, 15, 16, 17, 18));
        List<Lotto> lottos = List.of(firstLotto, secondLotto, thirdLotto);
        Lottos myLottos = new Lottos(lottos);

        assertThat(myLottos.getLottos()).isEqualTo(lottos);
    }

    @Test
    @DisplayName("당첨 결과를 올바르게 취합한다")
    void 당첨_결과를_올바르게_취합한다(){
        Lotto winnigLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto missLotto = new Lotto(List.of(8, 9, 10, 11, 12, 13));
        List<Lotto> lottos=List.of(firstLotto, secondLotto, missLotto);
        Lottos myLottos = new Lottos(lottos);

        Map<LottoRank, Integer> result = myLottos.calculateAllLottoResult(winnigLotto, bonusNumber);

        assertThat(result).containsOnly(
                entry(LottoRank.FIRST, 1),
                entry(LottoRank.SECOND, 1),
                entry(LottoRank.MISS, 1)
        );
    }
}
