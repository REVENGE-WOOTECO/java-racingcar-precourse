package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String REQUEST_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String REQUEST_INPUT_TRY_NUMBER = "시도할 회수는 몇회인가요?";
    private final static String COMMA_DELIMITER = ",";

    private final static String ERROR_WHITE_SPACE_NAME = "[ERROR] 공백인 이름은 입력할 수 없습니다. 다시 입력해주세요.";
    private final static String ERROR_NAME_LENGTH = "[ERROR] 길이가 5 초과인 이름은 입력할 수 없습니다. 다시 입력해주세요.";
    private final static String ERROR_DUPLICATE_NAME = "[ERROR] 동일한 이름은 입력할 수 없습니다. 다시 입력해주세요.";

    public List<String> inputCarNames() {
        System.out.println(REQUEST_INPUT_CAR_NAMES);
        List<String> carNames = splitAndTrimInputCarNames();
        while (!isValidInputCarNames(carNames)) {
            carNames = splitAndTrimInputCarNames();
        }
        return carNames;
    }

    private List<String> splitAndTrimInputCarNames() {
        String[] inputCarNames = Console.readLine().split(COMMA_DELIMITER, -1);
        return Arrays.stream(inputCarNames)
            .map(String::trim)
            .collect(Collectors.toList());
    }

    private boolean isValidInputCarNames(List<String> carNames) {
        try {
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
