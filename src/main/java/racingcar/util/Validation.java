package racingcar.util;

import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toSet;

public class Validation {

    private static final int NAME_MAX_LENGTH = 5;

    public void validateCarNames(String[] carNames) {
        validateMaxLength(carNames);
        validateDuplicateCarName(carNames);
    }

    private void validateMaxLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > NAME_MAX_LENGTH) {
                throw new IllegalArgumentException("자동차명의 최대길이는 5입니다");
            }
        }
    }

    private void validateDuplicateCarName(String[] carNames) {
        Set<String> carNameSet = stream(carNames).collect(toSet());
        if (carNameSet.size() != carNames.length) {
            throw new IllegalArgumentException("중복되는 자동차명이 존재합니다");
        }
    }
}
