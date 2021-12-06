package racingcar.domain;

import java.util.Objects;
import java.util.regex.Pattern;
import racingcar.ErrorMessage;

public class RacingCarGame {

    private static final int MIN_ROUND = 1;

    private static final String NUMBER_PATTERN = "^[0-9]*$";
    private static final String BLANK = " ";

    private final Cars cars;
    private final int totalRound;
    private final RoundHistory roundHistory;

    private RacingCarGame(Cars cars, int totalRound, RoundHistory roundHistory) {
        this.cars = cars;
        this.totalRound = totalRound;
        this.roundHistory = roundHistory;
    }

    public static RacingCarGame create(Cars cars, String totalRound, RoundHistory roundHistory) {
        return new RacingCarGame(cars, validateTotalRound(totalRound), roundHistory);
    }

    private static int validateTotalRound(String totalRound) {
        if (isInvalidTotalRound(totalRound)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TOTAL_ROUND);
        }

        if (isInvalidTotalRoundRange(totalRound)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TOTAL_ROUND_RANGE);
        }

        return Integer.parseInt(totalRound);
    }

    private static boolean isInvalidTotalRound(String totalRound) {
        return Objects.isNull(totalRound) || totalRound.isEmpty() ||
            totalRound.contains(BLANK) || !Pattern.matches(NUMBER_PATTERN, totalRound);
    }

    private static boolean isInvalidTotalRoundRange(String totalRound) {
        return Integer.parseInt(totalRound) < MIN_ROUND;
    }

    public String start() {
        for (int round = 1; round <= totalRound; round++) {
            roundStart();
        }
        return cars.getWinnerCarNames();
    }

    private void roundStart() {
        cars.moveCars();
        roundHistory.recordRoundHistory(cars);
    }

    public RoundHistory getRoundHistory() {
        return roundHistory;
    }
}
