package racingcar.domain;

import racingcar.strategy.MovableStrategy;

public class Car {
    private static final String ERROR_WHITE_SPACE_NAME = "[ERROR] 공백인 이름은 입력할 수 없습니다. 다시 입력해주세요.";
    private static final String ERROR_NAME_LENGTH = "[ERROR] 길이가 5 초과인 이름은 입력할 수 없습니다. 다시 입력해주세요.";
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private final MovableStrategy movableStrategy;
    private int position = 0;

    public Car(String name, MovableStrategy movableStrategy) {
        validateWhiteSpaceName(name);
        validateNameLength(name);
        this.name = name;
        this.movableStrategy = movableStrategy;
    }

    private void validateWhiteSpaceName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_WHITE_SPACE_NAME);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    public void move() {
        if (movableStrategy.isMovable()) {
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
