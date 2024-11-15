package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("자동차 이름과 위치 문자열로 반환")
    void formatRacingCar(){
        // given
        RacingCar car = new RacingCar("red");
        car.forward();

        // when
        String response = car.formatRacingCar();

        // then
        assertEquals(response, "red : -");
    }

}