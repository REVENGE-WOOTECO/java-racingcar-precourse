package racingcar.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputValidator Unit Test")
class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "345", "가나다", "abc3", "4fjd", "ab, cd", "Ab cd"})
    void regex_알파벳_아닌_값_검증(String input) {
        Assertions.assertThat(InputValidator.validateNameList(input)).isEqualTo(null);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,bcdefg,d", ",bcd,def", "afdfdf,asdfasa,bbbbbbb"})
    void length_실패_검증(String input) {
        Assertions.assertThat(InputValidator.validateNameList(input)).isEqualTo(null);
    }

    @ParameterizedTest
    @CsvSource({"'abc', 1", "'dfefs', 1", "'lee,jh', 2", "'jo,hy,pobi', 3", "'dfs,hy', 2"})
    void regex_정상_입력_검증(String input, int result) {
        Assertions.assertThat(InputValidator.validateNameList(input).size()).isEqualTo(result);
    }

}