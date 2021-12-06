package racingcar;

import java.util.Collections;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ConstNumber;

public class Car {
	private final String name;
	private int position = 0;

	public Car(String name) {
		this.name = name;
	}

	public void play() {
		int randomNumber = Randoms.pickNumberInRange(ConstNumber.RANDOM_NUMBER_MIN, ConstNumber.RANDOM_NUMBER_MAX);
		if (randomNumber >= ConstNumber.MOVE_CONDITION_RANDOM_NUMBER) {
			move();
		}
	}

	public void move() {
		position++;
	}

}
