package lotto.util;

import lotto.domain.Lotto;

import java.util.List;

public class BonusNumberInputValidator {
    private BonusNumberInputValidator() {

    }

    public static void validateBonusNumberInput(String input, Lotto winningLotto) {
        isBlank(input);
        isNumeric(input);
        int bonusNumber = Integer.parseInt(input);
        isValidRange(bonusNumber);
        isUnique(bonusNumber, winningLotto.getNumbers());
    }

    private static void isBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 필수입니다.");
        }
    }

    private static void isNumeric(String input) {
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력은 숫자여야 합니다.");
        }
    }

    private static void isValidRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    private static void isUnique(int bonusNumber, List<Integer> lotto) {
        if(lotto.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

}
