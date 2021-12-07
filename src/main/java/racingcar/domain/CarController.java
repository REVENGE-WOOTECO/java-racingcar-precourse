package racingcar.domain;

import java.util.List;

public class CarController {

    private final CarGroups carGroups;

    private CarController(CarGroups carGroups) {
        this.carGroups = carGroups;
    }

    public static CarController of(List<String> carNames) {
        return new CarController(CarGroups.of(carNames));
    }

    public void gameStart(int repeatCount) {
        System.out.println("\n실행 결과");
        repeatGame(repeatCount);
        printWinner();
    }

    private void repeatGame(int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            carGroups.executeMovingOrNot();
            System.out.println();
        }
    }

    private void printWinner() {
        System.out.print("최종 우승자 : " + carGroups.showWinner());
    }
}
