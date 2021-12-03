package racingcar.domain;

import static racingcar.utils.Constant.*;

import java.util.Collections;

public class Car {
    private final String name;
    private int position = ZERO_NUMBER;

    public Car(String name) {
        this.name = name;
    }

    public int decideMoving(int randomNumber) {
        if (randomNumber >= MOVING_LOWER_LIMIT) {
            position++;
        }
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isYourPosition(int maxNumber) {
        return maxNumber == position;
    }

    public void showStatus() {
        System.out.println(name + " : " + printBar());
    }

    private String printBar() {
        return String.join("", Collections.nCopies(this.position, BAR));
    }

}
