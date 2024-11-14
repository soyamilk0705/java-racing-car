package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarRandomTest {

    @RepeatedTest(10)
    @DisplayName("0부터 9까지 랜덤 값 생성")
    void random(){

        RacingCarRandom random = new RacingCarRandom();
        int result = random.createRandomNum();

        assertTrue(result > -1);
        assertTrue(result < 10);
    }

}
