package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarController {

    private static final List<Car> carList = new ArrayList<>();

    public static CarController makeCarList(List<String> cars) {

        for (String carName : cars) {
            carList.add(new Car(carName));
        }
        return new CarController();
    }

    public List<String> gameStart(int repeatCount) {

        return null;
    }
}
