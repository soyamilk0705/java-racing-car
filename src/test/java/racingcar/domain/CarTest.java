package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp(){
        car = new Car("red");
    }

    @Test
    @DisplayName("자동차 전진")
    void move(){
        // given, when
        car.move(4);

        // then
        assertThat(car.getLocation().toString()).isEqualTo("-");
    }

    @Test
    @DisplayName("자동차 전진 안함")
    void notMove(){
        // given, when
        car.move(3);

        // then
        assertThat(car.getLocation().toString()).isEqualTo("");
    }

    @Test
    @DisplayName("우승자여서 true 반환")
    void isWinner_true(){
        // given
        Location location = new Location(2);

        car.move(4);
        car.move(4);

        // when
        boolean response = car.isWinner(location);

        // then
        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("우승자가 아니여서 false 반환")
    void isWinner_false(){
        // given
        Location location = new Location(2);

        // when
        boolean response = car.isWinner(location);

        // then
        assertThat(response).isFalse();
    }

    @Test
    @DisplayName("더 큰 Location 반환")
    void getMaxLocation1(){
        // given
        Location location = new Location(3);

        // when
        Location response = car.getMaxLocation(location);

        // then
        assertThat(response).isEqualTo(location);
    }

    @Test
    @DisplayName("더 큰 Location 반환")
    void getMaxLocation2(){
        // given
        Location location = new Location(1);

        car.move(4);
        car.move(4);

        // when
        Location response = car.getMaxLocation(location);

        // then
        assertThat(response).isEqualTo(car.getLocation());
    }

}
