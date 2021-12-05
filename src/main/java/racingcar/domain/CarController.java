package racingcar.domain;

import static java.util.stream.Collectors.*;
import static racingcar.utils.Constant.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CarController {

    private static final List<Car> carList = new ArrayList<>();
    private static int maxNumber = ZERO_NUMBER;

    public static CarController makeCarList(List<String> cars) {

        for (String carName : cars) {
            carList.add(new Car(carName));
        }
        return new CarController();
    }

    public void gameStart(int repeatCount) {

        System.out.println("\n실행 결과");

        for (int i = 0; i < repeatCount; i++) {
            executeEachCar();
            System.out.println();
        }
        showWinner();
    }

    private void showWinner() {

        String result = carList.stream()
            .filter(car -> car.isYourPosition(maxNumber))
            .map(Car::getName)
            .collect(joining(JOIN_DELIMITER));

        System.out.print("최종 우승자 : " + result);
    }

    private void executeEachCar() {
        for (Car car : carList) {
            maxNumber = Math.max(maxNumber, car.decideMoving(Randoms.pickNumberInRange(ZERO_NUMBER, MAXIMUM_NUMBER)));
            car.showStatus();
        }
    }
}