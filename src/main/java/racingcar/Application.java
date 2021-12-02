package racingcar;

import java.util.List;

import racingcar.domain.CarController;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {

        CarController carController = new CarController();

        List<String> cars = InputView.requestCarInput();
        carController.makeCarList(cars);

        int repeatCount = InputView.requestRepeatCount();
        carController.gameStart(repeatCount);

    }
}
