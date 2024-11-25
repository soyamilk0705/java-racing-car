package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarUtilTest {

    @RepeatedTest(10)
    @DisplayName("랜덤 값 생성")
    void createRandomNumber(){
        // given, when
        int response = RacingCarUtil.createRandomNumber();

        // then
        assertTrue(response > 0);
        assertTrue(response < 10);
    }

    @Test
    @DisplayName("문자열 쉼표 기준으로 분리")
    void splitName(){
        // given, when
        String[] response = RacingCarUtil.splitName("red,blue,pink");

        assertThat(response).isEqualTo(new String[]{"red", "blue", "pink"});
    }

    @Test
    @DisplayName("문자열 쉼표 기준으로 분리 시 공백 포함되어 있는 경우")
    void splitNameContainsSpace(){
        // given, when
        String[] response = RacingCarUtil.splitName("red,          blue,pink");

        assertThat(response).isEqualTo(new String[]{"red", "blue", "pink"});
    }

    @Test
    @DisplayName("문자열 쉼표 기준으로 분리 시 쉼표 없는 경우")
    void splitNameNotContainsComma(){
        // given, when
        String[] response = RacingCarUtil.splitName("racingCar^^");

        assertThat(response).isEqualTo(new String[]{"racingCar^^"});
    }

}
