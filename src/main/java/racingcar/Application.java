package racingcar;

public class Application {
	private final static String PRINT_MESSAGE_EXECUTION_RESULT = "실행결과";

	public static void main(String[] args) {
		InputUser inputUser = new InputUser();
		String[] inputCarName = inputUser.inputCarNames().split(",");

		int inputPlayTime = inputUser.inputPlayTimes();
		System.out.println();

		System.out.println(PRINT_MESSAGE_EXECUTION_RESULT);
		RacingGame racingGame = new RacingGame();
		racingGame.playGame(inputCarName, inputPlayTime);
	}
}
