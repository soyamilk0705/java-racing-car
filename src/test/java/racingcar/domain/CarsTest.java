package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.RaceResult;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("쉼표를 기준으로 이름 분할")
    void Cars(){
        // given
        Cars cars = new Cars("red, blue, pink");

        // when
        RaceResult response = cars.race(3);

        // then
    }

}
