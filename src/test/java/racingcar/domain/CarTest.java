package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 전진")
    void move(){
        // given
        Car car = new Car("red");

        // when
        car.move();

        // then
        assertThat(car.getLocation()).isEqualTo(1);
    }
}
