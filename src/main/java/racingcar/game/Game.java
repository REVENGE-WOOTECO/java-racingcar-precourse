package racingcar.game;

import racingcar.Car;
import racingcar.util.UserInput;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {

    private final UserInput userInput;

    public Game(UserInput userInput) {
        this.userInput = userInput;
    }

    public void play() {
        GameInfo gameInfo = initGame();
        executeAsTryCount(gameInfo);
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

    private void executeAsTryCount(GameInfo gameInfo) {
        for (int i = 0; i < gameInfo.getTryCount(); i++) {
            moveCars(gameInfo);
            printCarsPosition(gameInfo);
        }
    }

    private void moveCars(GameInfo gameInfo) {
        for (Car car : gameInfo.getCars()) {
            int carPickNumber = pickNumberInRange(0, 9);
            if (carPickNumber >= 4) {
                car.forward();
            }
        }
    }

    private void printCarsPosition(GameInfo gameInfo) {
        gameInfo.printCarsPosition();
    }
}

