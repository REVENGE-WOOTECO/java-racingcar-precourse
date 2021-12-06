package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.*;
import static java.lang.Integer.*;
import static java.util.Arrays.stream;

public class UserInput {

    private static final String COMMA = ",";

    public String[] carsInput() {
        return stream(readLine().split(COMMA))
                .map(String::trim)
                .toArray(String[]::new);
    }

    public int stepInput() {
        return parseInt(readLine());
    }
}
