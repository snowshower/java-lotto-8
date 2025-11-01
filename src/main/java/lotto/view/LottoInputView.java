package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.util.LottoInputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInputView {

    public Lotto lotto() {
        List<Integer> lotto = inputLotto();
        return new Lotto(lotto);
    }

    private List<Integer> inputLotto(){
        while(true){
            try{
                System.out.println("당첨 번호를 입력해주세요.");
                String lotto= Console.readLine();

                LottoInputValidator.validateLottoInput(lotto);

                return Arrays.stream(lotto.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
