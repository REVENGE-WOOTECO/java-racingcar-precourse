package racingcar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RacingGame {
	public final static String PRINT_MESSAGE_FINAL_WINNER = "최종 우승자 : ";

	List<Car> carList = new LinkedList<>();

	public void playGame(String[] inputCarName, int inputPlayTime) {
		getCarList(inputCarName);

		for (int i = 0; i < inputPlayTime; i++) {
			for (Car car : carList) {
				car.playOnce();
			}
			System.out.println();
		}

		List<String> winner = getWinner(carList);
		printWinner(winner);
	}

	private void getCarList(String[] inputCarName) {
		for (String s : inputCarName) {
			carList.add(new Car(s));
		}
	}

	private List<String> getWinner(List<Car> carList) {
		List<String> winner = new ArrayList<>();
		for (Car car : carList) {
			if (car.getPosition() == getMaxPosition()) {
				winner.add(car.getName());
			}
		}
		return winner;
	}

	private int getMaxPosition() {
		int maxPosition = 0;

		for (Car car : carList) {
			if (maxPosition < car.getPosition()) {
				maxPosition = car.getPosition();
			}
		}

		return maxPosition;
	}

	private void printWinner(List<String> winner) {
		System.out.print(PRINT_MESSAGE_FINAL_WINNER);

		System.out.print(String.join(", ",winner));
	}

}
