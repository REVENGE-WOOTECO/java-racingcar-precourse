package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class CarController {

    private static final List<Car> carList = new ArrayList<>();

    public static CarController makeCarList(List<String> cars) {

        for (String carName : cars) {
            carList.add(new Car(carName));
        }
        return new CarController();
    }

    public void gameExecute(int repeatCount) {

        System.out.println("\n실행 결과");

        for (int i = 0; i < repeatCount; i++) {
            execute();
            System.out.println();
        }

    }

    private void execute() {
        for (Car car : carList) {
            car.decideMoving(Randoms.pickNumberInRange(0, 9));
            System.out.println(car);
        }
    }
}
