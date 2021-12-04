package racingcar;

import java.util.List;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Cars cars = Cars.from(inputView.inputCarNames());
        int tryCount = inputView.inputTryCount();
        startGame(cars, tryCount);
    }

    private static void startGame(Cars cars, int tryCount) {
        OutputView.printExecutionResultHeader();
        for (int i = 0; i < tryCount; i++) {
            cars.move();
            OutputView.printEachGameState(cars.toCarDtos());
        }
        List<String> winnerCarNames = cars.findWinnerCarNames();
        OutputView.printWinnerCarNames(winnerCarNames);
    }
}
