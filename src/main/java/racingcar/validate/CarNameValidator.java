package racingcar.validate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class CarNameValidator {
	public final static int CAR_NAME_DUPLICATE_COUNT = 1;
	public final static int CAR_NAME_LENGTH = 5;

	public void carNameValidator(String inputCarName) {
		List<String> carNameList = Arrays.asList(inputCarName.split(","));

		checkCarNameLength(carNameList);
		checkCarNameBlank(carNameList);
		checkCarNameDuplicate(carNameList);
		checkCarNameLastComma(carNameList);
	}

	private void checkCarNameLength(List<String> carNameList){
		for (String s : carNameList) {
			if (s.length() > CAR_NAME_LENGTH || s.isEmpty()) {
				throw new IllegalArgumentException();
			}
		}
	}

	private void checkCarNameBlank(List<String> carNameList){
		for (String s : carNameList) {
			if (s.trim().isEmpty()) {
				throw new IllegalArgumentException();
			}
		}
	}

	private void checkCarNameLastComma(List<String> carNameList){
		if(Pattern.matches("/,$/", carNameList.toString())){
			throw new IllegalArgumentException();
		}
	}

	private void checkCarNameDuplicate(List<String> carNameList){
		if(carNameList.stream().distinct().count() != carNameList.size()){
			throw new IllegalArgumentException();
		}
	}
}
