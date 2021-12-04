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
        moveAndPrintEachResult(cars, tryCount);
        printWinnerNames(cars);
    }

    private static void moveAndPrintEachResult(Cars cars, int tryCount) {
        OutputView.printExecutionResultHeader();
        for (int i = 0; i < tryCount; i++) {
            cars.move();
            OutputView.printEachGameState(cars.toCarDtos());
        }
    }

    private static void printWinnerNames(Cars cars) {
        List<String> winnerCarNames = cars.findWinnerCarNames();
        OutputView.printWinnerCarNames(winnerCarNames);
    }

}
