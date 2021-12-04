package racingcar.view;

import java.util.List;

import racingcar.dto.CarDto;

public class OutputView {
    private static final String EXECUTION_RESULT_HEADER = "\n실행 결과";
    private static final String DASH = "-";
    private static final String COLON = " : ";

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
}
