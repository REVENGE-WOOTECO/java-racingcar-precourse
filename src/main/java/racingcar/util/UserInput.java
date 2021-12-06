package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class UserInput {

    private static final String COMMA = ",";

    public String[] carsInput() {
        return Arrays.stream(Console.readLine().split(COMMA))
                .map(String::trim)
                .toArray(String[]::new);
    }
}
