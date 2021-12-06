package racingcar.game;

public enum GameSetting {
    RANGE_START(0),
    RANGE_END(9),
    MIN_RANDOM(4),
    MAX_RETRY_COUNT(10);

    private final int value;

    GameSetting(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
