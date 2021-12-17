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

    public Cars(List<Car> cars) {
        validateDuplicate(cars);
        this.cars = cars;
    }

    private void validateDuplicate(List<Car> cars) {
        Set<Car> nonDuplicateNames = new HashSet<>(cars);
        if (nonDuplicateNames.size() != cars.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
    }

    public void move(MovableStrategy movableStrategy) {
        for (Car car : cars) {
            car.move(movableStrategy);
        }
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
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalArgumentException(ERROR_NOT_FIND_MAX_POSITION));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
