package racingcar.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private static final int MOVE_POSITION_LENGTH = 1;

    private final int value;

    public Position(int position) {
        this.value = position;
    }

    public Position movePosition() {
        return new Position(this.value + MOVE_POSITION_LENGTH);
    }

    public boolean isSamePosition(Position position) {
        return this.value == position.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Position o) {
        return this.value - o.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Position position = (Position)o;
        return getValue() == position.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
