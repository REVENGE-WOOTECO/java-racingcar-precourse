package racingcar.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import racingcar.strategy.MovableStrategy;

public class Cars {
    private static final String ERROR_DUPLICATE_NAME = "[ERROR] 동일한 이름은 입력할 수 없습니다. 다시 입력해주세요.";
    private static final String ERROR_NOT_FIND_MAX_POSITION = "[ERROR] 최대 거리를 찾을 수 없습니다.";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames, MovableStrategy movableStrategy) {
        validateDuplicate(carNames);
        List<Car> cars = carNames.stream()
            .map(carName -> new Car(carName, movableStrategy))
            .collect(Collectors.toList());
        return new Cars(cars);
    }

    private static void validateDuplicate(List<String> carNames) {
        Set<String> nonDuplicateNames = new HashSet<>(carNames);
        if (nonDuplicateNames.size() != carNames.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> findWinnerCarNames() {
        int maxPosition = findMaxPosition();
        return cars.stream()
            .filter(car -> car.isMaxPosition(maxPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public int findMaxPosition() {
        return cars.stream()
            .map(Car::getPosition)
            .max(Integer::compare)
            .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FIND_MAX_POSITION));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
