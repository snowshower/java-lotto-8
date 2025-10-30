package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.BonusNumber;

public class BonusNumberInputView {

    public BonusNumber bonusNumberInput(){
        int bonusNumber = inputBonusNumber();
        return new BonusNumber(bonusNumber);
    }

    private int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }
}
