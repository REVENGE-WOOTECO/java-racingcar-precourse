package racingcar.dto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.Position;

class CarDtoTest {

    @Test
    @DisplayName("Car로 부터 CarDto가 제대로 생성 되는 지")
    void convertCarToCarDto() {
        // given
        Car car = new Car("pobi");
        // when
        CarDto carDto = CarDto.from(car);

        // then
        assertThat(carDto.getName()).isEqualTo("pobi");
        assertThat(carDto.getPosition()).isEqualTo(new Position(0));
    }

}
