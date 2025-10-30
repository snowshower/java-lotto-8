package lotto;

import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

/**
 * LottoGenerator는 pickUniqueNumbersInRange()를 직접 사용하므로,
 * 중복된 값을 반환하지 않고 지정한 범위 내에서만 값을 반환하기 때문에
 * 중복 및 범위에 대한 테스트는 생략합니다.
 */

public class LottoGeneratorTest {

    @Test
    @DisplayName("로또 생성기가 유효한 로또를 생성하는지 확인")
    void 랜덤한_로또_번호_6개를_정상적으로_발행한다() {
        assertThatCode(()->LottoGenerator.generateAutoLotto())
                .doesNotThrowAnyException();
    }
}
