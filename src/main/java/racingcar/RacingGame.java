package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
	private final static String PRINT_MESSAGE_FINAL_WINNER = "최종 우승자 : ";

	Cars cars = new Cars();

	public void playGame(String[] inputCarName, int inputPlayTime) {
		cars.getCarList(inputCarName);

		for (int i = 0; i < inputPlayTime; i++) {
			for (Car car : cars.getCarList()) {
				car.playOnce();
			}
			System.out.println();
		}

		List<String> winner = getWinner(cars.getCarList());
		printWinner(winner);
	}

	private List<String> getWinner(List<Car> carList) {
		int maxPosition = cars.getMaxPosition();
		return carList.stream()
			.filter(t -> t.isMaxPosition(maxPosition))
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private void printWinner(List<String> winner) {
		System.out.print(PRINT_MESSAGE_FINAL_WINNER);

		System.out.print(String.join(", ",winner));
	}

}
