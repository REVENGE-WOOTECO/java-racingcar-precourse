package racingcar.util;

import java.util.Set;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;

public class Validation {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String PATTERN_REGEX = "-?\\d+";
    private static final Pattern PATTERN = Pattern.compile(PATTERN_REGEX);

    public void validateCarNames(String[] carNames) {
        validateMaxLength(carNames);
        validateDuplicateCarName(carNames);
    }

    public void validateIsNumber(String numberString) {
        if (!PATTERN.matcher(numberString).matches()) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }

    private void validateMaxLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException("[ERROR] 자동차명의 최대길이는 5입니다.");
            }
        }
    }

    private void validateDuplicateCarName(String[] carNames) {
        Set<String> carNameSet = stream(carNames).collect(toSet());
        if (carNameSet.size() != carNames.length) {
            throw new IllegalArgumentException("[ERROR] 중복되는 자동차명이 존재합니다.");
        }
    }
}
