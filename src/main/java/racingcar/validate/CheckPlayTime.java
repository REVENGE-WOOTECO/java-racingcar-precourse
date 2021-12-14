package racingcar.validate;

public class CheckPlayTime {
	public final static int PLAY_TIME_LEAST_COUNT = 1;

	public CheckPlayTime() {
	}

	public CheckPlayTime(int playTime) {
		checkPlayTime(playTime);
	}

	public void checkPlayTime(int playTime) {
		if (playTime < PLAY_TIME_LEAST_COUNT) {
			throw new IllegalArgumentException();
		}
	}
}
