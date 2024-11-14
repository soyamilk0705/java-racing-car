package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarsTest {

    private RacingCars cars;

    @BeforeEach
    void setUp(){
        cars = new RacingCars(new String[]{"red", "blue"});
    }


    @Test
    @DisplayName("레이싱카 리스트 객체 생성")
    void RacingCars(){
        // then
        List<RacingCar> response = cars.getCars();

        assertEquals(response.size(), 2);
    }


    @Test
    @DisplayName("우승자 이름 반환")
    void getWinnerName(){
        // given
        RacingCar car1 = cars.getCars().get(0);
        car1.forward();

        // when
        String response = cars.getWinnerName();

        // then
        assertEquals(response, car1.getName());
    }

    @Test
    @DisplayName("레이싱카 이름으로 리스트 객체 생성")
    void createCar(){
        // given

        // when
        List<RacingCar> response = cars.createCar(new String[]{"red", "blue"});

        // then
        assertEquals(response.size(), 2);
        assertEquals(response.get(0).getName(), "red");
        assertEquals(response.get(1).getName(), "blue");
    }

    @Test
    @DisplayName("우승자 이름 반환 시 우승자 다수일 경우")
    void getMultipleWinnerName(){
        RacingCar car1 = cars.getCars().get(0);
        RacingCar car2 = cars.getCars().get(1);
        car1.forward();
        car2.forward();

        // when
        String response = cars.getWinnerName();

        // then
        assertEquals(response, car1.getName() + ", " + car2.getName());

    }
}
