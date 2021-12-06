package racingcar;

import java.util.LinkedList;
import java.util.List;

public class RacingGame {
	public void game(String[] inputCarName, int inputPlayTime) {
		List<Car> carList = new LinkedList<>();

		for(String s: inputCarName){
			carList.add(new Car(s));
		}

		for (int i = 0; i < inputPlayTime; i++) {
			for (Car car : carList) {
				car.play();
			}
			System.out.println();
		}
	}
}
