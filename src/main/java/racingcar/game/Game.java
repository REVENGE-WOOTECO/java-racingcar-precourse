package racingcar.game;

import racingcar.Car;
import racingcar.util.UserInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.game.GameSetting.*;

public class Game {

    private static final String DELIMITER = ", ";
    private final UserInput userInput;

    public Game(UserInput userInput) {
        this.userInput = userInput;
    }

    public void play() {
        GameInfo gameInfo = initGame();
        executeAsTryCount(gameInfo);
        List<String> winnerNames = createWinnerNames(gameInfo);
        printWinnerNames(winnerNames);
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
            int carPickNumber = pickNumberInRange(RANGE_START.value(), RANGE_END.value());
            if (carPickNumber >= MIN_RANDOM.value()) {
                car.forward();
            }
        }
    }

    private void printCarsPosition(GameInfo gameInfo) {
        gameInfo.printCarsPosition();
        System.out.println();
    }

    private List<String> createWinnerNames(GameInfo gameInfo) {
        List<Car> cars = gameInfo.getCars();
        Collections.sort(cars);
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = cars.get(0).getPosition();
        for (Car car : cars) {
            if (car.getPosition() < maxPosition) {
                break;
            }
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }

    private void printWinnerNames(List<String> winnerNames) {
        String joinWinnerNames = String.join(DELIMITER, winnerNames);
        System.out.println("최종 우승자 : " + joinWinnerNames);
    }
}

