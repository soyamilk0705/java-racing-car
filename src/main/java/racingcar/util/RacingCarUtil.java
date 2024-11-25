package racingcar.util;

import java.util.Random;

public class RacingCarUtil {
    private static final int RANDOM_BOUND = 9;

    private static final Random random = new Random();

    public static int createRandomNumber() {
        return random.nextInt(RANDOM_BOUND) + 1;
    }

    public static String[] splitName(String carNameStr) {
        return carNameStr.replaceAll(" ", "").split(",");
    }

}
