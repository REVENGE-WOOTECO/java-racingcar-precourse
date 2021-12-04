package racingcar;

import java.util.List;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames);
        int tryCount = inputView.inputTryCount();
        OutputView.printExecutionResultHeader();
        for (int i = 0; i < tryCount; i++) {
            cars.move();
            OutputView.printGameState(cars.toCarDto());
        }
        List<String> winnerCarNames = cars.findWinnerCarNames();
        OutputView.printWinnerCarNames(winnerCarNames);
    }
}
