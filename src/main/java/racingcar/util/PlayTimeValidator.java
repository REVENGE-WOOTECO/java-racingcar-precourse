package racingcar.util;

public class PlayTimeValidator {
	private final static int PLAY_TIME_LEAST_COUNT = 1;

	private PlayTimeValidator() {
	}

	private static PlayTimeValidator instance = new PlayTimeValidator();

	public static PlayTimeValidator getInstance() {
		return instance;
	}

	public void playTimeValidator(int playTime) {
		if (playTime < PLAY_TIME_LEAST_COUNT) {
			throw new IllegalArgumentException();
		}
	}
}
