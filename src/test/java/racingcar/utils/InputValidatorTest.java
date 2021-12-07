package racingcar.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("InputValidator Unit Test")
class InputValidatorTest {

    @ParameterizedTest
    @DisplayName("알파벳이 아닌 값이 들어온 경우 빈 List를 반환한다.")
    @ValueSource(strings = {"123", "345", "가나다", "abc3", "4fjd", "ab, cd", "Ab cd"})
    void regex_no_alphabet(String input) {
        assertThat(InputValidator.validateNameList(input).isEmpty()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("길이가 1 ~ 5가 아닐 경우 빈 List를 반환한다.")
    @ValueSource(strings = {"a,bcdefg,d", ",bcd,def", "afdfdf,asdfasa,bbbbbbb"})
    void length_fail(String input) {
        assertThat(InputValidator.validateNameList(input).isEmpty()).isTrue();
    }

    @ParameterizedTest
    @DisplayName("정상적인 문자열이 입력된 경우 해당 사이즈를 반환한다.")
    @CsvSource({"'abc', 1", "'dfefs', 1", "'lee,jh', 2", "'jo,hy,pobi', 3", "'dfs,hy', 2"})
    void regex_normal(String input, int result) {
        assertThat(InputValidator.validateNameList(input).size()).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("0 이상의 숫자가 아닐 경우 false 를 반환한다.")
    @ValueSource(strings = {"a", "bcd", "1db", "-12", "2af", "-234"})
    void count_fail(String input) {
        assertThat(InputValidator.validateCount(input)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("0이상의 숫자일 경우 True 를 반환한다.")
    @ValueSource(strings = {"12", "1", "0", "23", "199", "77777"})
    void count_success(String input) {
        assertThat(InputValidator.validateCount(input)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("중복된 이름이 있을 경우 빈 List를 반환한다.")
    @ValueSource(strings = {"lee,lee", "jo,jo", "aaa,aaa"})
    void validate_duplicated_name(String input) {
        assertThat(InputValidator.validateNameList(input).isEmpty()).isTrue();
    }
}
