package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }

        if (!numbers.stream().allMatch(n -> n >= 1 && n <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }
}
