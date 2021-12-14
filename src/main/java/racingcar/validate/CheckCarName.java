package racingcar.validate;

import java.util.Collections;
import java.util.List;

import racingcar.constant.ConstNumber;

public class CheckCarName {
	public CheckCarName() {}

	public CheckCarName(List<String> carNameList) {
		checkCarNameLength(carNameList);
		checkCarNameEmpty(carNameList);
		checkCarNameBlank(carNameList);
		checkCarNameDuplicate(carNameList);
		checkCarNameLastComma(carNameList);
	}

	public void checkCarNameLength(List<String> carNameList){
		for (String s : carNameList) {
			if (s.length() > ConstNumber.CAR_NAME_LENGTH ) {
				throw new IllegalArgumentException();
			}
		}
	}

	public void checkCarNameEmpty(List<String> carNameList){
		for (String s : carNameList) {
			if (s.isEmpty()) {
				throw new IllegalArgumentException();
			}
		}
	}

	public void checkCarNameBlank(List<String> carNameList){
		for (String s : carNameList) {
			if (s.equals(" ")) {
				throw new IllegalArgumentException();
			}
		}
	}

	public void checkCarNameLastComma(List<String> carNameList){
		if (carNameList.get(carNameList.size()-1).equals(",")) {
			throw new IllegalArgumentException();
		}
	}

	public void checkCarNameDuplicate(List<String> carNameList){
		for (String s : carNameList) {
			if (Collections.frequency(carNameList, s) > ConstNumber.CAR_NAME_DUPLICATE_COUNT) {
				throw new IllegalArgumentException();
			}
		}
	}
}
