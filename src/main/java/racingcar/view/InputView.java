package racingcar.view;

import java.util.List;
import java.util.Scanner;

import racingcar.utils.InputValidator;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static List<String> requestCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> result;
        String input;

        do {
            input = sc.nextLine();
        } while ((result = InputValidator.validateNameList(input)) == null);

        return result;
    }

    public static int requestRepeatCount() {

        return 0;
    }
}
