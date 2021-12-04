package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final static String ERROR_WHITE_SPACE_NAME = "[ERROR] 공백인 이름은 입력할 수 없습니다. 다시 입력해주세요.";
    private final static String ERROR_NAME_LENGTH = "[ERROR] 길이가 5 초과인 이름은 입력할 수 없습니다. 다시 입력해주세요.";
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MOVING_FORWARD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateWhiteSpaceName(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateWhiteSpaceName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_WHITE_SPACE_NAME);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (MOVING_FORWARD <= randomValue) {
            position++;
        }
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
