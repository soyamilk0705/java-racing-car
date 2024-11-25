package racingcar.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarException;
import racingcar.exception.messages.ErrorMessages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5글자 넘지 않아 예외 미발생")
    void checkValidCarName(){
        // given, when, then
        assertDoesNotThrow(() -> Validator.checkValidCarName("blue"));
    }

    @Test
    @DisplayName("자동차 이름이 5글자 넘어 예외 발생")
    void checkValidCarName_carException(){
        // given, when
        CarException fail = assertThrows(CarException.class, () -> Validator.checkValidCarName("green"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.CAR_NAME_OVER_FIVE);

    }

    @Test
    @DisplayName("자동차 이름이 5글자가 넘지 않아 true 반환")
    void isNameLengthLessThanFive_true(){
        // given, when
        boolean response = Validator.isNameLengthLessThanFive("blue");

        // then
        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("자동차 이름이 5글자가 넘어 false 반환")
    void isNameLengthLessThanFive_false(){
        // given, when
        boolean response = Validator.isNameLengthLessThanFive("green");

        // then
        assertThat(response).isFalse();
    }
}
