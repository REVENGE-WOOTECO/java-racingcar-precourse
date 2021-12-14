package racingcar.util;

public class PlayTimeValidator {
	public final static int PLAY_TIME_LEAST_COUNT = 1;

	private PlayTimeValidator() {
	}

	private static PlayTimeValidator instance = new PlayTimeValidator();

	public void playTimeValidator(int playTime) {
		if (playTime < PLAY_TIME_LEAST_COUNT) {
			throw new IllegalArgumentException();
		}
	}

	public static PlayTimeValidator getInstance() {
		return instance;
	}
}
