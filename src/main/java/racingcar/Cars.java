package racingcar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
	private List<Car> carList = new LinkedList<>();

	public void getCarList(String[] inputCarName) {
		for (String s : inputCarName) {
			carList.add(new Car(s));
		}
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

	public List<Car> getCarList() {
		return carList;
	}
}
