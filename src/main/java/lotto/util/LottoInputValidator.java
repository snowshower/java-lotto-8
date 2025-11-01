package lotto.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoInputValidator {
    private LottoInputValidator() {

    }

    public static void validateLottoInput(String input) {
        isNULLOrBlank(input);
        String[] inputToLotto = input.split(",");
        isAllNumeric(inputToLotto);
        isValidCount(inputToLotto);
        List<Integer> lotto= Arrays.stream(inputToLotto)
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
        isValidRange(lotto);
        isUnique(lotto);
    }

    private static void isNULLOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호를 비워둘 수 없습니다.");
        }
    }

    private static void isAllNumeric(String[] input) {
        for (String s : input) {
            try{
                Integer.parseInt(s.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 입력은 숫자여야 합니다.");
            }
        }
    }

    private static void isValidCount(String[] input) {
        if (input.length != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호 개수는 6개여야 합니다.");
        }
    }

    private static void isUnique(List<Integer> lotto) {
        Set<Integer> uniqueLotto = new HashSet<>(lotto);
        if (lotto.size() != uniqueLotto.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
    }

    private static void isValidRange(List<Integer> lotto) {
        if (!lotto.stream()
                .allMatch(lottoNumber -> lottoNumber >= 1 && lottoNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }
}
