package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RoundHistory;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        Cars cars = requestCarNames();
        RacingCarGame game = requestRound(cars);

        String winners = game.start();

        OutputView.printHeader();
        OutputView.printRoundHistory(game.getRoundHistory());
        OutputView.printGameWinners(winners);
    }

    public static Cars requestCarNames() {
        try {
            String carNames = InputView.requestInputCarNames();
            return Cars.create(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestCarNames();
        }
    }

    public static RacingCarGame requestRound(Cars cars) {
        try {
            String round = InputView.requestInputRound();
            return RacingCarGame.create(cars, round, new RoundHistory());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return requestRound(cars);
        }
    }
}
