package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;

public class PurchaseInputView {

    public PurchaseAmount purchaseInput(){
        int purchaseAmount = inputPurchaseAmount();
        return new PurchaseAmount(purchaseAmount);
    }

    private int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        return purchaseAmount;
    }
}
