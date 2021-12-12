package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.dto.CarNameDto;
import racingcar.strategy.RandomMovableStrategy;
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
    void isCarsImmutable() {
        // given
        InputView inputView = new InputView();
        command("pobi,min");

        // when
        List<CarNameDto> carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames, new RandomMovableStrategy());
        carNames.add(new CarNameDto("hwan"));

        // then
        assertThat(cars.getCars().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Cars에 중복된 값이 들어오면 Exception")
    void hasCarsDuplicate() {
        // given
        List<CarNameDto> carNames = new ArrayList<>();
        carNames.add(new CarNameDto("pobi"));
        carNames.add(new CarNameDto("pobi"));

        // when

        // then
        assertThatThrownBy(() -> Cars.from(carNames, new RandomMovableStrategy()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 동일한 이름은 입력할 수 없습니다. 다시 입력해주세요.");
    }

    @Test
    @DisplayName("자동차들이 모두 전진하는 지")
    void isCarsMove() {
        // given
        InputView inputView = new InputView();
        command("pobi,min");
        List<CarNameDto> carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames, new RandomMovableStrategy());

        assertRandomNumberInRangeTest(
            () -> {
                //when
                cars.move();

                //then
                assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
                assertThat(cars.getCars().get(1).getPosition()).isEqualTo(1);
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
        List<CarNameDto> carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames, new RandomMovableStrategy());

        assertRandomNumberInRangeTest(
            () -> {
                //when
                cars.move();

                //then
                assertThat(cars.getCars().get(0).getPosition()).isEqualTo(1);
                assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
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
        List<CarNameDto> carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames, new RandomMovableStrategy());

        assertRandomNumberInRangeTest(
            () -> {
                //when
                cars.move();

                //then
                assertThat(cars.getCars().get(0).getPosition()).isEqualTo(0);
                assertThat(cars.getCars().get(1).getPosition()).isEqualTo(0);
            },
            STOP
        );

    }

    @Test
    @DisplayName("자동차들 중 최대 거리가 잘 구해지는 지")
    void isCarsMaxPosition() {
        // given
        InputView inputView = new InputView();
        command("pobi,min");
        List<CarNameDto> carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames, new RandomMovableStrategy());

        assertRandomNumberInRangeTest(
            () -> {
                //when
                cars.move();
                cars.move();

                //then
                assertThat(cars.findMaxPosition()).isEqualTo(2);
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("자동차들 중 우승자가 한명일 때")
    void isFindWinnerCarName() {
        // given
        InputView inputView = new InputView();
        command("pobi,min,hwan");
        List<CarNameDto> carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames, new RandomMovableStrategy());

        // when
        assertRandomNumberInRangeTest(
            () -> {
                //when
                cars.move();

                //then
                assertThat(cars.findWinnerCarNames().size()).isEqualTo(1);
                assertThat(cars.findWinnerCarNames()).contains("pobi");
            },
            MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    @DisplayName("자동차들 중 우승자가 여러 명 일 때")
    void isFindWinnerCarNames() {
        // given
        InputView inputView = new InputView();
        command("pobi,min,hwan");
        List<CarNameDto> carNames = inputView.inputCarNames();
        Cars cars = Cars.from(carNames, new RandomMovableStrategy());

        // when
        assertRandomNumberInRangeTest(
            () -> {
                //when
                cars.move();

                //then
                assertThat(cars.findWinnerCarNames().size()).isEqualTo(2);
                assertThat(cars.findWinnerCarNames()).contains("pobi");
                assertThat(cars.findWinnerCarNames()).contains("min");
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }
}
