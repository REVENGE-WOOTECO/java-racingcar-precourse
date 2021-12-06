package racingcar.view;

import racingcar.domain.RoundHistory;

public class OutputView {

    private static final String HEADER = "실행 결과";
    private static final String WINNER_OUTPUT_PREFIX = "최종 우승자 : ";

    public static void printHeader() {
        System.out.println(HEADER);
    }

    public static void printRoundHistory(RoundHistory roundHistories) {
        for (String roundHistory : roundHistories.getHistories()) {
            System.out.println(roundHistory);
        }
    }

    public static void printGameWinners(String winners) {
        System.out.println(WINNER_OUTPUT_PREFIX + winners);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
