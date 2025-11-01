package lotto.controller;

import lotto.domain.*;
import lotto.view.BonusNumberInputView;
import lotto.view.LottoInputView;
import lotto.view.OutputView;
import lotto.view.PurchaseInputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final PurchaseInputView purchaseInputView;
    private final LottoInputView lottoInputView;
    private final BonusNumberInputView bonusNumberInputView;
    private final OutputView outputView;

    public LottoController(PurchaseInputView purchaseInputView, LottoInputView lottoInputView,
                           BonusNumberInputView bonusNumberInputView, OutputView outputView) {
        this.purchaseInputView = purchaseInputView;
        this.lottoInputView = lottoInputView;
        this.bonusNumberInputView = bonusNumberInputView;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseAmount purchaseAmount = purchaseInputView.purchaseInput();
        long count = purchaseAmount.calculateLottoTickets();
        outputView.printPurchaseAmount(count);

        List<Lotto> myLotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto=LottoGenerator.generateAutoLotto();
            myLotto.add(lotto);
        }

        Lottos myLottos = new Lottos(myLotto);
        outputView.printLottos(myLottos);

        Lotto winningLotto = lottoInputView.lotto();
        BonusNumber bonusNumber = bonusNumberInputView.bonusNumberInput();

        Map<LottoRank, Integer> result = myLottos.calculateAllLottoResult(winningLotto, bonusNumber);
        LottoStatistics lottoStatistics=new LottoStatistics(purchaseAmount, result);
        outputView.printLottoResult(result);
        outputView.printLottoStatistics(lottoStatistics);

    }
}
