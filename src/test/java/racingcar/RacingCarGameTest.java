package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarGameTest {

    private RacingCars cars;

    @BeforeEach
    void setUp(){
        cars = new RacingCars(new String[]{"red", "blue"});
    }


    @Test
    @DisplayName("랜덤 값이 4 이상이여서 전진")
    void raceMore4(){
        // given
        RacingCarGame game = new RacingCarGame(cars);
        RacingCar car1 = cars.getCars().get(0);

        // when
        game.race(car1, 4);

        // then
        assertEquals(car1.getLocation(), 1);
    }

    @Test
    @DisplayName("랜덤 값이 4 이하여서 전진 안함")
    void raceLessThan4(){
        // given, when
        RacingCarGame game = new RacingCarGame(cars);
        RacingCar car1 = cars.getCars().get(0);

        // when
        game.race(car1, 3);

        // then
        assertEquals(car1.getLocation(), 0);
    }

}
