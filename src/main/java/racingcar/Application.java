package racingcar;

import racingcar.constant.ConstMessage;

public class Application {
	public static void main(String[] args) {
		InputUser inputUser = new InputUser();
		String[] inputCarName = inputUser.inputCarNames().split(",");

		int inputPlayTime = inputUser.inputPlayTimes();
		System.out.println();

		System.out.println(ConstMessage.PRINT_MESSAGE_EXECUTION_RESULT);
		RacingGame racingGame = new RacingGame();
		racingGame.playGame(inputCarName, inputPlayTime);
	}
}
