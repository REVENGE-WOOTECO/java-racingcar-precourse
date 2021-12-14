package racingcar.validate;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class CheckCarName {
	public final static int CAR_NAME_DUPLICATE_COUNT = 1;
	public final static int CAR_NAME_LENGTH = 5;

	public CheckCarName(List<String> carNameList) {
		checkCarNameLength(carNameList);
		checkCarNameBlank(carNameList);
		checkCarNameDuplicate(carNameList);
		checkCarNameLastComma(carNameList);
	}

	public void checkCarNameLength(List<String> carNameList){
		for (String s : carNameList) {
			if (s.length() > CAR_NAME_LENGTH || s.isEmpty()) {
				throw new IllegalArgumentException();
			}
		}
	}

	public void checkCarNameBlank(List<String> carNameList){
		for (String s : carNameList) {
			if (s.trim().isEmpty()) {
				throw new IllegalArgumentException();
			}
		}
	}

	public void checkCarNameLastComma(List<String> carNameList){
		if(Pattern.matches("/,$/", carNameList.toString())){
			throw new IllegalArgumentException();
		}
	}

	public void checkCarNameDuplicate(List<String> carNameList){
		if(carNameList.stream().distinct().count() != carNameList.size()){
			throw new IllegalArgumentException();
		}
	}
}
