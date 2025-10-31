package lotto.domain;

import java.util.List;

public class LottoResultCalculator {

    private LottoResultCalculator() {}

    public static LottoRank lottoResultCalculate(Lotto resultLotto, Lotto myLotto, BonusNumber bonusNumber){
        List<Integer> resultNumbers=resultLotto.getNumbers();
        List<Integer> myNumbers=myLotto.getNumbers();

        long matchCount=myNumbers.stream()
                .filter(resultNumbers::contains)
                .count();

        boolean bonusMatch=myNumbers.contains(bonusNumber.getBonusNumber());

        return LottoRank.valueOf((int) matchCount, bonusMatch);
    }
}
