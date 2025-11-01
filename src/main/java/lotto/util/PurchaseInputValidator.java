package lotto.util;

public final class PurchaseInputValidator {
    private PurchaseInputValidator() {

    }

    public static void validatePurchaseInput(String input) {
        isNULLOrBlank(input);
        isNumeric(input);
        long purchaseAmount=Long.parseLong(input);
        isBiggerThanZero(purchaseAmount);
        isNotDiviseByZero(purchaseAmount);
    }

    private static void isNULLOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 비워둘 수 없습니다.");
        }
    }

    private static void isNumeric(String input) {
        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    private static void isBiggerThanZero(long purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 양수를 입력해주세요.");
        }
    }

    private static void isNotDiviseByZero(long purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
        }
    }
}
