package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ConstMessage;
import racingcar.validate.Validator;

public class InputUser {
	Validator validation = new Validator();

	public String inputCarNames() {
		String inputCarNames;

		while (true) {
			System.out.println(ConstMessage.REQUEST_MESSAGE_INPUT_CAR_NAME);
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

	public int inputPlayTimes() {
		String inputPlayTimes;

		while (true) {
			System.out.println(ConstMessage.REQUEST_MESSAGE_INPUT_PLAY_TIME);
			inputPlayTimes = Console.readLine();
			try {
				validation.validatePlayTime(Integer.parseInt(inputPlayTimes));
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(ConstMessage.ERROR_MESSAGE_WRONG_PLAY_TIME);
			}
		}

		return Integer.parseInt(inputPlayTimes);
	}
}
