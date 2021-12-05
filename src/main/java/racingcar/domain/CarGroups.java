package racingcar.domain;

import static java.util.stream.Collectors.*;
import static racingcar.utils.Constant.*;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CarGroups {

    private final List<Car> cars;

    private CarGroups(List<Car> cars) {
        this.cars = cars;
    }

    public static CarGroups of(List<String> carNames, List<Car> cars) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new CarGroups(cars);
    }

    public void executeMovingOrNot() {
        for (Car car : cars) {
            car.decideMoving(Randoms.pickNumberInRange(ZERO_NUMBER, MAXIMUM_NUMBER));
        }
    }

    public String showWinner() {
        int winnerPosition = findWinnerPosition();
        return cars.stream()
            .filter(car -> car.isYourPosition(winnerPosition))
            .map(Car::getName)
            .collect(joining(JOIN_DELIMITER));
    }

    private int findWinnerPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(ZERO_NUMBER);
    }
}
