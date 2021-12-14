package racingcar.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CarNameValidator {
	private final static int CAR_NAME_LENGTH = 5;

	private CarNameValidator() {
	}

	private static CarNameValidator instance = new CarNameValidator();

	public static CarNameValidator getInstance() {
		return instance;
	}

	public void carNameValidator(String inputCarName) {
		List<String> carNameList = Arrays.asList(inputCarName.split(","));

		checkCarNameLength(carNameList);
		checkCarNameBlank(carNameList);
		checkCarNameDuplicate(carNameList);
		checkCarNameLastComma(carNameList);
	}

	private void checkCarNameLength(List<String> carNameList){
		carNameList.stream()
			.filter(carName -> carName.length() > CAR_NAME_LENGTH || carName.isEmpty())
			.findAny()
			.ifPresent(t -> {
				throw new IllegalArgumentException();
			});
	}

	private void checkCarNameBlank(List<String> carNameList){
		carNameList.stream()
			.filter(carName -> carName.trim().isEmpty())
			.findAny()
			.ifPresent(t -> {
				throw new IllegalArgumentException();
			});
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
