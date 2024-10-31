package calculator;

import calculator.message.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("뮨자열 덧셈 계산기 빈값 입력")
    void splitAndSum_inputEmpty(){
        // given, when
        int response = StringAddCalculator.splitAndSum("");

        // then
        assertThat(response).isEqualTo(0);
    }

    @Test
    @DisplayName("뮨자열 덧셈 계산기 빈값 입력")
    void splitAndSum_inputNull(){
        // given, when
        int response = StringAddCalculator.splitAndSum(null);

        // then
        assertThat(response).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열 덧셈 계산기 콤마 입력")
    void splitAndSum_comma(){
        // given, when
        int response = StringAddCalculator.splitAndSum("1,2");

        // then
        assertThat(response).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열 덧셈 계산기 콜론 입력")
    void splitAndSum_colon(){
        // given, when
        int response = StringAddCalculator.splitAndSum("1:2");

        // then
        assertThat(response).isEqualTo(3);
    }

    @Test
    @DisplayName("문자열 덧셈 계산기 사용자 지정 구분자 입력")
    void splitAndSum_customDelimiter(){
        // given, when
        int response = StringAddCalculator.splitAndSum("//;\n1;2;3");

        // then
        assertThat(response).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열 덧셈 계산 숫자 하나 입력한 경우")
    void splitAndSum_singleNumber(){
        // given, when
        int response = StringAddCalculator.splitAndSum("13");

        // then
        assertThat(response).isEqualTo(13);
    }

    @Test
    @DisplayName("문자열 덧셈 계산기 숫자 이외의 값 입력")
    void splitAndSum_inputNotNumber(){
        // given, when
        NumberFormatException fail = assertThrows(NumberFormatException.class, () -> StringAddCalculator.splitAndSum("문자열"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_INPUT);
    }

    @Test
    @DisplayName("문자열 덧셈 계산기 지정되어 있지 않은 구분자 입력")
    void splitAndSum_inputInvalidDelimiter(){
        // given, when
        NumberFormatException fail = assertThrows(NumberFormatException.class, () -> StringAddCalculator.splitAndSum("1;2;3;"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_INPUT);
    }

    @Test
    @DisplayName("문자열 덧셈 계산기 음수 입력")
    void splitAndSum_inputNegativeNumber(){
        // given, when
        IllegalArgumentException fail = assertThrows(IllegalArgumentException.class, () -> StringAddCalculator.splitAndSum("1,-2,3"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_NEGATIVE_NUMBER_INPUT);
    }


}
