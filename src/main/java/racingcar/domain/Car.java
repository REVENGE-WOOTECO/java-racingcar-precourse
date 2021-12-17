package racingcar.domain;

import java.util.Objects;

import racingcar.strategy.MovableStrategy;

public class Car {
    private static final String ERROR_WHITE_SPACE_NAME = "[ERROR] 공백인 이름은 입력할 수 없습니다. 다시 입력해주세요.";
    private static final String ERROR_NAME_LENGTH = "[ERROR] 길이가 5 초과인 이름은 입력할 수 없습니다. 다시 입력해주세요.";
    private static final int MAX_NAME_LENGTH = 5;

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
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_LENGTH);
        }
    }

    public void move(MovableStrategy movableStrategy) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car)o;
        return Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
