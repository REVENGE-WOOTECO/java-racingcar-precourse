package racingcar.game;

import racingcar.Car;

import java.util.List;

public class GameInfo {

    private final List<Car> cars;
    private final int tryCount;

    public GameInfo(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void printCarsPosition() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
