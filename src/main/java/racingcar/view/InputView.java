package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_CAR_NAMES_REQUEST = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ROUND_REQUEST = "시도할 회수는 몇회인가요?";

    public static String requestInputCarNames() {
        System.out.println(INPUT_CAR_NAMES_REQUEST);
        return Console.readLine();
    }

    public static String requestInputRound() {
        System.out.println(INPUT_ROUND_REQUEST);
        return Console.readLine();
    }
}
