package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.ResultView;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultViewTest {
    private RacingCars cars;

    @BeforeEach
    void setUp(){
        cars = new RacingCars(new String[]{"red", "blue"});
    }








}
