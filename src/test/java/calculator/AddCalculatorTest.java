package calculator;

import calculator.message.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddCalculatorTest {

    @Test
    @DisplayName("덧셈 계산")
    void add(){
        // given, when
        AddCalculator addCalculator = new AddCalculator(new String[]{"1", "2", "3"});

        // when
        int response = addCalculator.add();

        // then
        assertThat(response).isEqualTo(6);
    }

    @Test
    @DisplayName("덧셈 계산 시 숫자 하나 입력한 경우")
    void add_singleNumber(){
        // given
        AddCalculator addCalculator = new AddCalculator(new String[]{"1"});

        // when
        int response = addCalculator.add();

        // then
        assertThat(response).isEqualTo(1);
    }

    @Test
    @DisplayName("덧셈 계산 시 음수가 포함된 경우")
    void add_inputNegativeNumber(){
        // given
        AddCalculator addCalculator = new AddCalculator(new String[]{"1", "-2", "3"});

        // when
        RuntimeException fail = assertThrows(RuntimeException.class, addCalculator::add);

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_NEGATIVE_NUMBER_INPUT);
    }

    @Test
    @DisplayName("덧셈 계산 시 숫자 이외의 값이 입력된 경우")
    void add_inputInvalidDelimiter(){
        // given
        AddCalculator addCalculator = new AddCalculator(new String[]{"1", "문", "3"});

        // when
        RuntimeException fail = assertThrows(RuntimeException.class, addCalculator::add);

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_INPUT);
    }

    @Test
    @DisplayName("문자열 검증 및 숫자로 변환")
    void validateAndConvert(){
        // given
        AddCalculator addCalculator = new AddCalculator(new String[]{});

        // when
        int response = addCalculator.validateAndConvert("122222");

        // then
        assertThat(response).isEqualTo(122222);
    }

    @Test
    @DisplayName("문자열 검증 및 숫자로 변환 시 숫자 이외의 문자열 포함되어 예외 발생")
    void validateAndConvert_inputNotNumber(){
        // given
        AddCalculator addCalculator = new AddCalculator(new String[]{});

        // when
        RuntimeException fail = assertThrows(RuntimeException.class, () -> addCalculator.validateAndConvert("1&2"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_INPUT);
    }

    @Test
    @DisplayName("문자열 검증 및 숫자로 변환 시 음수 입력으로 예외 발생")
    void validateAndConvert_inputNegativeNumber(){
        // given
        AddCalculator addCalculator = new AddCalculator(new String[]{});

        // when
        RuntimeException fail = assertThrows(RuntimeException.class, () -> addCalculator.validateAndConvert("-20"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_NEGATIVE_NUMBER_INPUT);
    }

}
