package racingcar;

import racingcar.game.Game;
import racingcar.util.UserInput;
import racingcar.util.Validator;

public class Application {

    public static void main(String[] args) {
        Validator validator = new Validator();
        UserInput userInput = new UserInput(validator);
        Game game = new Game(userInput);
        game.play();
    }
}
