package lotto;

import lotto.controller.LottoController;
import lotto.view.BonusNumberInputView;
import lotto.view.LottoInputView;
import lotto.view.OutputView;
import lotto.view.PurchaseInputView;

public class Application {
    public static void main(String[] args) {

        PurchaseInputView purchaseInputView = new PurchaseInputView();
        LottoInputView lottoInputView = new LottoInputView();
        BonusNumberInputView bonusNumberInputView = new BonusNumberInputView();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(purchaseInputView, lottoInputView,
                bonusNumberInputView, outputView);

        lottoController.run();
    }
}
