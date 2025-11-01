package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.PurchaseAmount;
import lotto.util.PurchaseInputValidator;

public class PurchaseInputView {

    public PurchaseAmount purchaseInput(){
        long purchaseAmount = inputPurchaseAmount();
        return new PurchaseAmount(purchaseAmount);
    }

    private long inputPurchaseAmount(){
        while(true){
            try{
                System.out.println("구입금액을 입력해주세요.");
                String input=Console.readLine();

                PurchaseInputValidator.validatePurchaseInput(input);

                return Long.parseLong(input);

            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
