package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		int maxPosition = getMaxPosition();
		return carList.stream().filter(t->t.isMaxPosition(maxPosition)).map(Car::getName).collect(Collectors.toList());
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
