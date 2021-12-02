package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void decideMoving(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
        }
    }

    @Override
    public String toString() {
        return name + " : " + printBar();
    }

    private String printBar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

}
