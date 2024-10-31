package calculator;

import calculator.message.ErrorMessages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddCalculatorTest {

    @Test
    @DisplayName("덧셈 계산")
    void sum(){
        // given, when
        AddCalculator addCalculator = new AddCalculator(new String[]{"1", "2", "3"});

        // when
        int response = addCalculator.sum();

        // then
        assertThat(response).isEqualTo(6);
    }

    @Test
    @DisplayName("덧셈 계산 시 숫자 하나 입력한 경우")
    void sum_singleNumber(){
        // given
        AddCalculator addCalculator = new AddCalculator(new String[]{"1"});

        // when
        int response = addCalculator.sum();

        // then
        assertThat(response).isEqualTo(1);
    }

    @Test
    @DisplayName("덧셈 계산 시 음수가 포함된 경우")
    void sum_inputNegativeNumber(){
        // given
        AddCalculator addCalculator = new AddCalculator(new String[]{"1", "-2", "3"});

        // when
        RuntimeException fail = assertThrows(RuntimeException.class, addCalculator::sum);

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_NEGATIVE_NUMBER_INPUT);
    }

    @Test
    @DisplayName("덧셈 계산 시 숫자 이외의 값이 입력된 경우")
    void sum_inputInvalidDelimiter(){
        // given
        AddCalculator addCalculator = new AddCalculator(new String[]{"1", "문", "3"});

        // when
        RuntimeException fail = assertThrows(RuntimeException.class, addCalculator::sum);

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.INVALID_INPUT);
    }

}
