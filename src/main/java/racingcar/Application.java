package racingcar;

public class Application {
    public static void main(String[] args) {
        InputUser inputUser = new InputUser();
        String[] inputCarName = inputUser.inputCarNames().split(",");
        int inputPlayTime = inputUser.inputPlayTimes();
        System.out.println();

        System.out.println("실행결과");
        RacingGame racingGame = new RacingGame();
        racingGame.playGame(inputCarName, inputPlayTime);
    }
}
