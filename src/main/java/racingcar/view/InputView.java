package racingcar.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String REQUEST_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";
    private static final String ERROR_WHITE_SPACE_NAME = "[ERROR] 공백인 이름은 입력할 수 없습니다. 다시 입력해주세요.";
    private static final String ERROR_NAME_LENGTH = "[ERROR] 길이가 5 초과인 이름은 입력할 수 없습니다. 다시 입력해주세요.";
    private static final String ERROR_DUPLICATE_NAME = "[ERROR] 동일한 이름은 입력할 수 없습니다. 다시 입력해주세요.";
    private static final String ERROR_TRY_COUNT_LETTER = "[ERROR] 시도 횟수는 숫자만 입력할 수 있습니다. 다시 입력해주세요.";
    private static final String ERROR_TRY_COUNT_RANGE = "[ERROR] 시도 횟수는 1이상의 숫자만 입력할 수 있습니다. 다시 입력해주세요.";

    private static final String COMMA_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_COUNT_NUMBER = 1;

    public List<String> inputCarNames() {
        System.out.println(REQUEST_INPUT_CAR_NAMES);
        List<String> carNames = splitInputCarNames();
        while (isNotValidInputCarNames(carNames)) {
            carNames = splitInputCarNames();
        }
        return carNames;
    }

    public int inputTryCount() {
        System.out.println(REQUEST_INPUT_TRY_COUNT);
        String tryCount = Console.readLine();
        while (!isValidInputTryNumber(tryCount)) {
            tryCount = Console.readLine();
        }
        return Integer.parseInt(tryCount);
    }

    private List<String> splitInputCarNames() {
        String[] inputCarNames = Console.readLine().split(COMMA_DELIMITER, -1);
        return Arrays.stream(inputCarNames)
            .collect(Collectors.toList());
    }

    private boolean isNotValidInputCarNames(List<String> carNames) {
        try {
            validateWhiteSpaceName(carNames);
            validateNameLength(carNames);
            validateDuplicate(carNames);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private void validateWhiteSpaceName(List<String> carNames) {
        boolean hasWhiteSpaceName = carNames.stream()
            .map(String::trim)
            .anyMatch(String::isEmpty);

        if (hasWhiteSpaceName) {
            throw new IllegalArgumentException(ERROR_WHITE_SPACE_NAME);
        }
    }

    private void validateNameLength(List<String> carNames) {
        boolean hasOverNameLength = carNames.stream()
            .anyMatch(x -> x.length() > MAX_NAME_LENGTH);

        if (hasOverNameLength) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    private void validateDuplicate(List<String> carNames) {
        Set<String> nonDuplicateNames = new HashSet<>(carNames);
        if (nonDuplicateNames.size() != carNames.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
    }

    private boolean isValidInputTryNumber(String tryCount) {
        try {
            validateDigit(tryCount);
            validateCountRange(tryCount);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void validateDigit(String tryCount) {
        boolean hasLetter = tryCount.chars()
            .anyMatch(Character::isLetter);

        if (hasLetter) {
            throw new IllegalArgumentException(ERROR_TRY_COUNT_LETTER);
        }
    }

    private void validateCountRange(String tryCount) {
        if (Integer.parseInt(tryCount) < MIN_COUNT_NUMBER) {
            throw new IllegalArgumentException(ERROR_TRY_COUNT_RANGE);
        }
    }
}
