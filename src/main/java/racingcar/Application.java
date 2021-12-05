package racingcar;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.CarController;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        List<String> carNames = InputView.requestCarInput();
        CarController carController = CarController.of(carNames);

        int repeatCount = InputView.requestRepeatCount();
        carController.gameStart(repeatCount);
    }
}
