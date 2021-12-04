package racingcar.view;

import java.util.List;

import racingcar.dto.CarDto;

public class OutputView {
    private static final String EXECUTION_RESULT_HEADER = "\n실행 결과";
    private static final String DASH = "-";
    private static final String COLON = " : ";
    private static final String COMMA_AND_BLANK = ", ";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    private OutputView() {
    }

    public static void printExecutionResultHeader() {
        System.out.println(EXECUTION_RESULT_HEADER);
    }

    public static void printGameState(List<CarDto> cars) {
        for (CarDto car : cars) {
            String result = car.getName() + COLON + makeDash(car.getPosition());
            System.out.println(result);
        }
        System.out.println();
    }

    private static String makeDash(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(DASH);
        }
        return sb.toString();
    }

    public static void printWinnerCarNames(List<String> winnerCarNames) {
        String winnerNames = String.join(COMMA_AND_BLANK, winnerCarNames);
        System.out.println(FINAL_WINNER + winnerNames);
    }
}
