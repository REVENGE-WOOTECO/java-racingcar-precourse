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

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public void play() {
		int randomNumber = Randoms.pickNumberInRange(ConstNumber.RANDOM_NUMBER_MIN, ConstNumber.RANDOM_NUMBER_MAX);
		if (randomNumber >= ConstNumber.MOVE_CONDITION_RANDOM_NUMBER) {
			move();
		}
		printPosition();
	}

	public void move() {
		position++;
	}

	public void printPosition() {
		System.out.print(name + " : ");
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

}
