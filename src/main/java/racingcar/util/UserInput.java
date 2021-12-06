package racingcar.util;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;

public class UserInput {

    private static final String COMMA = ",";

    private final Validator validator;

    public UserInput(Validator validator) {
        this.validator = validator;
    }

    public String[] carsInput() {
        String[] carNames = stream(readLine().split(COMMA))
                .map(String::trim)
                .toArray(String[]::new);
        validator.validateCarNames(carNames);
        return carNames;
    }

    public int stepInput() {
        String numberString = readLine();
        validator.validateIsNumber(numberString);
        return parseInt(numberString);
    }
}
