package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
	private final static int RANDOM_NUMBER_MIN = 0;
	private final static int RANDOM_NUMBER_MAX = 9;
	private final static int MOVE_CONDITION_RANDOM_NUMBER = 4;

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

	public void playOnce() {
		int randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN, RANDOM_NUMBER_MAX);
		if (randomNumber >= MOVE_CONDITION_RANDOM_NUMBER) {
			move();
		}
		printPosition();
	}

	public boolean isMaxPosition(int maxPosition){
		return position == maxPosition;
	}

	private void move() {
		position++;
	}

	private void printPosition() {
		System.out.print(name + " : ");
		for (int i = 0; i < position; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	@Override
	public String toString() {
		return "Car{" +
			"name='" + name + '\'' +
			", position=" + position +
			'}';
	}
}
