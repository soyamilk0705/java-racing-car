package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarTest {

    private RacingCar car;

    @BeforeEach
    void setUp(){
        car = new RacingCar("red");
    }

    @Test
    @DisplayName("레이싱 카 위치 출력")
    void printToString(){
        // given
        car.forward();

        // when
        String response = car.toString();

        // then
        assertEquals(response, "red : -");

    }

    @Test
    @DisplayName("레이싱 카 위치값 문자 그림으로 변경")
    void drawLocation(){
        // when
        String response = car.drawLocation(5);

        // then
        assertEquals(response, "-----");
    }

}
