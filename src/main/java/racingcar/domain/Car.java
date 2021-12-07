package racingcar.domain;

import static racingcar.utils.Constant.*;

import java.util.Collections;

public class Car {

    private final String name;
    private int position = ZERO_NUMBER;

    public Car(String name) {
        this.name = name;
    }

    public void decideMoving(int randomNumber) {
        if (randomNumber >= MOVING_LOWER_LIMIT) {
            position++;
        }
        showStatus();
    }

    public void showStatus() {
        System.out.println(name + " : " + printBar());
    }

    private String printBar() {
        return String.join("", Collections.nCopies(this.position, BAR));
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isYourPosition(int maxNumber) {
        return maxNumber == position;
    }
}
