package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("CarController Unit Test")
class CarControllerTest {

    // @ParameterizedTest
    // @DisplayName("생성 테스트")
    // @MethodSource("carControllerParameterProvider")
    // void 생성_테스트(List<String> cars) {
    //     CarController.makeCarList(cars);
    //     Assertions.assertThat(true).isEqualTo(true);
    // }
    //
    // static Stream<Arguments> carControllerParameterProvider() {
    //     return Stream.of(
    //         arguments(Arrays.asList(1, 3, 6), 9, Arrays.asList(2, 4, 7)),
    //         arguments(Arrays.asList(2, 3, 4), 1, Arrays.asList(2, 3, 4)));
    // }
}