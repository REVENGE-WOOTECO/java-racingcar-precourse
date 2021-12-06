package racingcar.validate;

import java.util.Collections;
import java.util.List;

import racingcar.constant.ConstNumber;

public class CheckCarName {
	public CheckCarName() {}

	public CheckCarName(List<String> carNameArray) {
		checkCarNameLength(carNameArray);
		checkCarNameEmpty(carNameArray);
		checkCarNameBlank(carNameArray);
		checkCarNameDuplicate(carNameArray);
		checkCarNameLastComma(carNameArray);
	}

	public void checkCarNameLength(List<String> carNameArray){
		for (String s : carNameArray) {
			if (s.length() > ConstNumber.CAR_NAME_LENGTH ) {
				throw new IllegalArgumentException();
			}
		}
	}

	public void checkCarNameEmpty(List<String> carNameArray){
		for (String s : carNameArray) {
			if (s.isEmpty()) {
				throw new IllegalArgumentException();
			}
		}
	}

	public void checkCarNameBlank(List<String> carNameArray){
		for (String s : carNameArray) {
			if (s.equals(" ")) {
				throw new IllegalArgumentException();
			}
		}
	}

	public void checkCarNameLastComma(List<String> carNameArray){
		if (carNameArray.get(carNameArray.size()-1).equals(",")) {
			throw new IllegalArgumentException();
		}
	}

	public void checkCarNameDuplicate(List<String> carNameArray){
		for (String s : carNameArray) {
			if (Collections.frequency(carNameArray, s) > ConstNumber.CAR_NAME_DUPLICATE_COUNT) {
				throw new IllegalArgumentException();
			}
		}
	}
}
