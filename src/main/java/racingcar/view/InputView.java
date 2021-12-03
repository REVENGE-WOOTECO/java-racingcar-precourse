package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String REQUEST_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String REQUEST_INPUT_TRY_NUMBER = "시도할 회수는 몇회인가요?";
    private final static String COMMA_DELIMITER = ",";

    public List<String> inputCarNames() {
        System.out.println(REQUEST_INPUT_CAR_NAMES);
        String inputCarNames = Console.readLine();
        return Arrays.stream(inputCarNames.split(COMMA_DELIMITER))
            .map(String::trim)
            .collect(Collectors.toList());
    }
}
