package racingcar.util;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;

public class UserInput {

    private static final String COMMA = ",";

    private final Validation validation;

    public UserInput(Validation validation) {
        this.validation = validation;
    }

    public String[] carsInput() {
        String[] carNames = stream(readLine().split(COMMA))
                .map(String::trim)
                .toArray(String[]::new);
        validation.validateCarNames(carNames);
        return carNames;
    }

    public int stepInput() {
        String numberString = readLine();
        validation.validateIsNumber(numberString);
        return parseInt(numberString);
    }
}
