package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ConstMessage;

public class InputUser {
	Validation validation = new Validation();

	public String inputCarNames() {
		String inputCarNames;

		while (true) {
			System.out.println(ConstMessage.REQUEST_INPUT_CAR_NAME);
			inputCarNames = Console.readLine();
			try {
				validation.validateCarName(inputCarNames);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ConstMessage.ERROR_MESSAGE_WRONG_CAR_NAME);
			}
		}

		return inputCarNames;
	}
}
