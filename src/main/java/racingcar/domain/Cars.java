package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.ErrorMessage;

public class Cars {

    public final static int ZERO = 0;
    public final static int MIN_CAR_NAME_LENGTH = 1;
    public final static int MAX_CAR_NAME_LENGTH = 5;

    private final static String NAME_SEPARATOR = ",";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public static Cars create(String inputCarNames) {
        String[] carNames = separateInputCarNames(inputCarNames);
        validateDuplicatedCarName(carNames);
        validateCarNameLength(carNames);
        return new Cars(Car.listOf(carNames));
    }

    private static String[] separateInputCarNames(String inputCarNames) {
        return inputCarNames.split(NAME_SEPARATOR);
    }

    private static void validateDuplicatedCarName(String[] carNames) {
        if (hasDuplicatedCarName(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_CAR_NAME);
        }
    }

    private static boolean hasDuplicatedCarName(String[] carNames) {
        return Arrays.stream(carNames).distinct().count() != carNames.length;
    }

    private static void validateCarNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (isInvalidCarNameLength(carName)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
            }
        }
    }

    private static boolean isInvalidCarNameLength(String carName) {
        return carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH;
    }

    public void moveCars() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String getWinnerCarNames() {
        int maxPosition = getMaxCarPosition();
        return cars.stream()
            .filter(car -> car.isSamePosition(maxPosition))
            .map(Car::getName)
            .collect(Collectors.joining(NAME_SEPARATOR));
    }

    private int getMaxCarPosition() {
        int maxPosition = ZERO;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
