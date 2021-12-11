package racingcar.strategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovableStrategy implements MovableStrategy {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;
    private static final int MOVING_FORWARD = 4;

    @Override
    public boolean isMovable() {
        int randomValue = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        return MOVING_FORWARD <= randomValue;
    }
}
