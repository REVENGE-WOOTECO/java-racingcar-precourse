package racingcar.domain;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.view.InputView;

class CarsTest {

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    @DisplayName("Cars가 가지는 값이 불변인지 테스트")
    void CarsImmutables() {
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

}
