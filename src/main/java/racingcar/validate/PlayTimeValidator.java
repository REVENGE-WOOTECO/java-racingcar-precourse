package racingcar.validate;

public class PlayTimeValidator {
	public final static int PLAY_TIME_LEAST_COUNT = 1;

	public void playTimeValidator(int playTime) {
		if (playTime < PLAY_TIME_LEAST_COUNT) {
			throw new IllegalArgumentException();
		}
	}
}
