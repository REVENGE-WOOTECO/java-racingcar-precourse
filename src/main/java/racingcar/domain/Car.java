package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MOVING_FORWARD = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        if (MOVING_FORWARD <= randomValue) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
