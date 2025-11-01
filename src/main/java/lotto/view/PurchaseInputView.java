package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;

public class PurchaseInputView {

    public PurchaseAmount purchaseInput(){
        long purchaseAmount = inputPurchaseAmount();
        return new PurchaseAmount(purchaseAmount);
    }

    private long inputPurchaseAmount(){
        System.out.println("구입금액을 입력해주세요.");
        long purchaseAmount = Integer.parseInt(Console.readLine());
        return purchaseAmount;
    }
}
