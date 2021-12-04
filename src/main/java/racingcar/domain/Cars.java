package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.dto.CarDto;

public class Cars {
    private static final String ERROR_NOT_FIND_MAX_POSITION = "[ERROR] 최대 거리를 찾을 수 없습니다.";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        List<Car> cars = carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
        return new Cars(cars);
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<String> findWinnerCarNames() {
        int maxPosition = findMaxPosition();
        return cars.stream()
            .filter(car -> car.isMaxPosition(maxPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        return cars.stream()
            .map(Car::getPosition)
            .max(Integer::compare)
            .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FIND_MAX_POSITION));
    }

    public List<CarDto> toCarDto() {
        return cars.stream()
            .map(CarDto::from)
            .collect(Collectors.toList());
    }

}
