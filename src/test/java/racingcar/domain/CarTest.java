package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.strategy.RandomMovableStrategy;

class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    @DisplayName("랜덤한 값이 4이상일 경우 전진")
    void isCarMove() {
        //given
        Car car = new Car("pobi");

        assertRandomNumberInRangeTest(
            () -> {
                //when
                car.move(new RandomMovableStrategy());
                //then
                assertThat(car.getPosition()).isEqualTo(1);
            },
            MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("랜덤한 값이 4미만일 경우 변화없음")
    void isCarStop() {
        //given
        Car car = new Car("pobi");

        assertRandomNumberInRangeTest(
            () -> {
                //when
                car.move(new RandomMovableStrategy());

                //then
                assertThat(car.getPosition()).isEqualTo(0);
            },
            STOP
        );
    }

    @Test
    @DisplayName("최대 거리 자동차가 맞는 지")
    void isCarMaxPosition() {
        // given
        Car car = new Car("pobi");
        int maxPosition = 2;

        assertRandomNumberInRangeTest(
            () -> {
                //when
                car.move(new RandomMovableStrategy());
                car.move(new RandomMovableStrategy());

                //then
                assertThat(car.isMaxPosition(maxPosition)).isEqualTo(true);
            },
            MOVING_FORWARD
        );

    }

}
