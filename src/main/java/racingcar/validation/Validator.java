package racingcar.validation;

import racingcar.exception.CarException;
import racingcar.exception.messages.ErrorMessages;

public class Validator {
    private static final int CAR_NAME_MAX = 5;

    public static void checkValidCarName(String carName){
        if(!isNameLengthLessThanFive(carName)){
            throw new CarException(ErrorMessages.CAR_NAME_OVER_FIVE);
        }
    }

    public static boolean isNameLengthLessThanFive(String carName) {
        return carName.length() < CAR_NAME_MAX;
    }



}
