package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.util.BonusNumberInputValidator;

public class BonusNumberInputView {

    public BonusNumber bonusNumberInput(Lotto winnigLotto){
        int bonusNumber = inputBonusNumber(winnigLotto);
        return new BonusNumber(bonusNumber);
    }

    private int inputBonusNumber(Lotto winningLotto){
        while(true){
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();

                BonusNumberInputValidator.validateBonusNumberInput(input, winningLotto);

                return Integer.parseInt(input);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
