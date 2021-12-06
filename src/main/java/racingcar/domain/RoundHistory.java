package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundHistory {

    private final static String NEWLINE = "\n";
    private final static String SEPARATOR = " : ";
    private final static String POSITION_BAR = "-";

    private final List<String> histories = new ArrayList<>();

    public void recordRoundHistory(Cars cars) {
        String history = getRoundHistory(cars);
        histories.add(history);
    }

    private String getRoundHistory(Cars cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars.getCars()) {
            sb.append(car.getName())
                .append(SEPARATOR)
                .append(getPositionBar(car))
                .append(NEWLINE);
        }
        return sb.toString();
    }

    private static String getPositionBar(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= car.getPosition(); i++) {
            sb.append(POSITION_BAR);
        }
        return sb.toString();
    }

    public List<String> getHistories() {
        return Collections.unmodifiableList(histories);
    }
}
