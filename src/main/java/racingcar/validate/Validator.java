package racingcar.validate;

import java.util.Arrays;
import java.util.List;

public class Validator {
	public void validateCarName(String inputCarName) {
		List<String> carNameArray = Arrays.asList(inputCarName.split(","));
		new CheckCarName(carNameArray);
	}
	public void validatePlayTime(int playTime) {
		new CheckPlayTime(playTime);
	}
}
