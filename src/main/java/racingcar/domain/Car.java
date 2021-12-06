package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Car {

    private static final int MAX_NUMBER_RANGE = 9;
    private static final int MIN_NUMBER_RANGE = 0;
    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static List<Car> listOf(String[] carNames) {
        return Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }

    public void move() {
        int number = pickRandomNumber();
        if (number >= MOVE_CONDITION) {
            position++;
        }
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }
}
