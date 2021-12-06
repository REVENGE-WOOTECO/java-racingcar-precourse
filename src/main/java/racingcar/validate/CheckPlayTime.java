package racingcar.validate;

import racingcar.constant.ConstNumber;

public class CheckPlayTime {
	public CheckPlayTime() {
	}

	public CheckPlayTime(int playTime) {
		checkPlayTime(playTime);
	}

	public void checkPlayTime(int playTime) {
		if (playTime < ConstNumber.PLAY_TIME_LEAST_COUNT) {
			throw new IllegalArgumentException();
		}
	}
}
