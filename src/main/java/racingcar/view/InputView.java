package racingcar.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.InputValidator;

public class InputView {

    public static List<String> requestCarInput() {
        List<String> result;
        String input;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        do {
            input = Console.readLine();
        } while ((result = InputValidator.validateNameList(input)) == null);

        return result;
    }

    public static int requestRepeatCount() {
        String input;
        System.out.println("시도할 회수는 몇회인가요?");
        do {
            input = Console.readLine();
        } while (!InputValidator.validateCount(input));

        return Integer.parseInt(input);
    }
}
