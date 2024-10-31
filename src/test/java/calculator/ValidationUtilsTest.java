package calculator;

import calculator.message.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ValidationUtilsTest {

    @Test
    @DisplayName("빈값 입력 시 true 반환")
    void inputEmpty(){
        // given, when
        boolean response = ValidationUtils.isEmptyOrNull("");

        // then
        assertTrue(response);
    }

    @Test
    @DisplayName("null 입력 시 true 반환")
    void inputNull(){
        // given, when
        boolean response = ValidationUtils.isEmptyOrNull(null);

        // then
        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("빈값, null 아닌 정상 입력 시 false 반환 ")
    void inputCorrect(){
        // given, when
        boolean response = ValidationUtils.isEmptyOrNull("1,2");

        // then
        assertThat(response).isFalse();
    }

    @Test
    @DisplayName("문자열 숫자를 숫자로 변경")
    void stringToInt(){
        // given, when
        int response = ValidationUtils.stringToInt("1");

        // then
        assertThat(response).isEqualTo(1);
    }

    @Test
    @DisplayName("문자열 숫자 변경 시 숫자 이외의 값 입력으로 예외 발생")
    void stringToIntInputNotNumber1(){
        // given, when
        RuntimeException fail = assertThrows(RuntimeException.class,
                () -> ValidationUtils.stringToInt("문자열"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_INPUT);
    }

    @Test
    @DisplayName("문자열 숫자 변경 시 숫자 이외의 값이 있어 예외 발생")
    void stringToIntInputNotNumber2(){
        // given, when
        RuntimeException fail = assertThrows(RuntimeException.class,
                () -> ValidationUtils.stringToInt("1/2"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_INPUT);
    }

    @Test
    @DisplayName("양수인지 확인")
    void isPositiveNumber(){
        // given, when, then
        assertDoesNotThrow(() -> ValidationUtils.isPositiveNumber(10));
    }

    @Test
    @DisplayName("문자열 숫자 변경 시 음수로 예외 발생")
    void stringToIntInputNegativeNumber(){
        // given, when
        RuntimeException fail = assertThrows(RuntimeException.class,
                () -> ValidationUtils.isPositiveNumber(-2));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_NEGATIVE_NUMBER_INPUT);
    }


}
