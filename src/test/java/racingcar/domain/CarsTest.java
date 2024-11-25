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
        Cars cars = new Cars("red, blue, pink");

        // when
        List<Car> response = cars.getCars();

        // then
        assertThat(response.size()).isEqualTo(3);
        assertThat(response).extracting(Car::getName).contains("red", "blue", "pink");
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
    @DisplayName("자동차 리스트에 객체 추가 시도로 에러 발생")
    void getCars(){
        Cars cars = new Cars("red,blue,pink");

        assertThrows(UnsupportedOperationException.class, () -> cars.getCars().add(new Car("test")));
    }

    @Test
    @DisplayName("우승자 이름 반환")
    void getWinnerName(){
        // given
        Cars cars = new Cars("red,blue,pink");

        for (Car car : cars.getCars()) {
            car.move();
        }

        // when
        String response = cars.getWinnerName();

        // then
        assertThat(response).isEqualTo("red, blue, pink");
    }

}
