package racingcar;

import java.util.Arrays;
import java.util.List;

public class Validation {
	public void validateCarName(String inputCarName) {
		List<String> carNameArray = Arrays.asList(inputCarName.split(","));
		new CheckCarName(carNameArray);
	}
}
