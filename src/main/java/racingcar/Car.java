package racingcar;

public class Car implements Comparable<Car>{

    private final StringBuilder positionGraph;
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        this.positionGraph = new StringBuilder();
    }

    public void forward() {
        position++;
        positionGraph.append("-");
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + positionGraph;
    }

    @Override
    public int compareTo(Car other) {
        return other.position - this.position;
    }
}
