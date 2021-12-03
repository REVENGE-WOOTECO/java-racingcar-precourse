package racingcar.domain;

import java.util.Collections;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int decideMoving(int randomNumber) {
        if (randomNumber >= 4) {
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
        return String.join("", Collections.nCopies(this.position, "-"));
    }

}
