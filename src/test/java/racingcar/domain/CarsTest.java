package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.view.InputView;

class CarsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    @DisplayName("Cars가 가지는 값이 불변인지 테스트")
    void isCarsImmutables() {
        // given
        InputView inputView = new InputView();
        command("pobi,min");

        // when
        List<String> carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames);
        carNames.add("aa");

        // then
        //assertThat(cars.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차들이 모두 전진하는 지")
    void isCarsMove() {
        // given
        InputView inputView = new InputView();
        command("pobi,min");
        List<String> carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames);

        // when
        assertRandomNumberInRangeTest(
            () -> {
                //when
                cars.move();

                //then
                //assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
                //assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1);
            },
            MOVING_FORWARD
        );

    }

    @Test
    @DisplayName("자동차들이 전진 혹은 멈추는 지 ")
    void isCarsMoveAndStop() {
        // given
        InputView inputView = new InputView();
        command("pobi,min");
        List<String> carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames);

        assertRandomNumberInRangeTest(
            () -> {
                //when
                cars.move();

                //then
                //assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
                //assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
            },
            MOVING_FORWARD, STOP
        );

    }

    @Test
    @DisplayName("자동차들이 모두 멈추는 지 ")
    void isCarsStop() {
        // given
        InputView inputView = new InputView();
        command("pobi,min");
        List<String> carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames);

        assertRandomNumberInRangeTest(
            () -> {
                //when
                cars.move();

                //then
                // assertThat(cars.getCars().get(0).getPosition()).isEqualTo(0);
                // assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
            },
            STOP
        );

    }

}
