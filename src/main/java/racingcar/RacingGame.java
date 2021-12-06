package racingcar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import racingcar.constant.ConstMessage;

public class RacingGame {
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

	public void getCarList(String[] inputCarName) {
		for (String s : inputCarName) {
			carList.add(new Car(s));
		}
	}

	public List<String> getWinner(List<Car> carList) {
		List<String> winner = new ArrayList<>();
		for (Car car : carList) {
			if (car.getPosition() == getMaxPosition()) {
				winner.add(car.getName());
			}
		}
		return winner;
	}

	public int getMaxPosition() {
		int maxPosition = 0;

		for (Car car : carList) {
			if (maxPosition < car.getPosition()) {
				maxPosition = car.getPosition();
			}
		}

		return maxPosition;
	}

	public void printWinner(List<String> winner) {
		System.out.print(ConstMessage.PRINT_MESSAGE_FINAL_WINNER);

		for (int i = 0; i < winner.size(); i++) {
			System.out.print(winner.get(i));
			if (winner.size() != 1 && i != winner.size() - 1) {
				System.out.print(", ");
			}
		}
	}

}
