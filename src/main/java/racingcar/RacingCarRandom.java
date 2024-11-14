package racingcar;

import java.util.Random;

public class RacingCarRandom {
    private static final int MAX_NUM = 9;
    private final Random random = new Random();

    public int createRandomNum() {
        return random.nextInt(MAX_NUM) + 1;
    }
}
