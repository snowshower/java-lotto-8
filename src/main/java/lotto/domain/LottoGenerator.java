package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public final class LottoGenerator {

    private LottoGenerator() {}

    public static Lotto generateAutoLotto(){
        List<Integer> autoLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(autoLotto);
    }
}
