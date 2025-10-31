package lotto.domain;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public Map<LottoRank, Integer> calculateAllLottoResult(Lotto winningLotto, BonusNumber bonusNumber){
        Map<LottoRank, Integer> result=new EnumMap<>(LottoRank.class);
        for (Lotto lotto : lottos) {
            LottoRank rank=LottoResultCalculator.lottoResultCalculate(winningLotto, lotto, bonusNumber);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }
}
