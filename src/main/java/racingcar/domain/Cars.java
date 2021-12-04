package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        return new Cars(cars);
    }

    public void move() {
        cars.forEach(Car::move);
    }
    
}
