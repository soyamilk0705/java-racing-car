package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarException;
import racingcar.exception.messages.ErrorMessages;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성")
    void createCar(){
        // given
        Cars cars = new Cars("red, blue");
        Name red = new Name("red");
        Name blue = new Name("blue");

        // when
        List<Car> response = cars.getCars();

        // then
        assertThat(response.size()).isEqualTo(2);
        assertThat(response).extracting(Car::getName).contains(red, blue);
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과로 예외 발생")
    void createCar_exception(){
        // given, when
        CarException fail = assertThrows(CarException.class, () -> new Cars("red, blue, green"));

        // then
        assertThat(fail.getMessage()).isEqualTo(ErrorMessages.CAR_NAME_OVER_FIVE);

    }


    @Test
    @DisplayName("우승자 이름 반환")
    void getWinnerName(){
        // given
        Cars cars = new Cars("red,blue,pink");

        Car car1 = cars.getCars().get(0);
        car1.move(4);
        Car car2 = cars.getCars().get(1);
        car2.move(4);

        // when
        String response = cars.getWinnerName();

        // then
        assertThat(response).isEqualTo(car1.getName().toString()+ ", " + car2.getName().toString());
    }

    @Test
    @DisplayName("레이싱 가장 큰 위치 반환")
    void getMaxLocation(){
        // given
        Cars cars = new Cars("red,blue,pink");
        Car car = cars.getCars().get(0);
        car.move(4);
        car.move(4);

        // when
        Location response = cars.getMaxLocation();

        // then
        assertThat(response).isEqualTo(car.getLocation());
    }

    @Test
    @DisplayName("자동차 리스트에 객체 추가 시도로 에러 발생")
    void getCars(){
        Cars cars = new Cars("red,blue,pink");

        assertThrows(UnsupportedOperationException.class, () -> cars.getCars().add(new Car("test")));
    }



}
