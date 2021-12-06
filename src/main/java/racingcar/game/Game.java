package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Car;
import racingcar.util.UserInput;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final UserInput userInput;

    public Game(UserInput userInput) {
        this.userInput = userInput;
    }

    public void play() {
        GameInfo gameInfo = initGame();
    }

    private GameInfo initGame() {
        String[] carNames = inputCarNames();
        int tryCount = inputTryCount();
        List<Car> cars = initCars(carNames);
        return new GameInfo(cars, tryCount);
    }

    private String[] inputCarNames() {
        System.out.println("경주할 자동차 이름");
        return userInput.inputCars();
    }

    private int inputTryCount() {
        System.out.println("시도할 횟수");
        return userInput.inputTryCount();
    }

    private List<Car> initCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}

