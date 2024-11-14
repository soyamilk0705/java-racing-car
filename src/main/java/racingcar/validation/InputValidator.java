package racingcar.validation;

import racingcar.message.RacingCarMessages;

import java.util.Arrays;

public class InputValidator {
    public static final int LIMIT_NAME_LENGTH = 5;

    public boolean isValidCarName(String[] inputArr) {
        return !isEmptyArray(inputArr) && Arrays.stream(inputArr).allMatch(this::isLessThanFiveCharacters);
        }

    public boolean isEmptyArray(String[] inputArr) {
        return inputArr.length == 0;
    }

    public boolean isLessThanFiveCharacters(String input){
        return input.length() < LIMIT_NAME_LENGTH;
    }

    public boolean isEmptyInput(String input) {
        if (input.isEmpty()){
            System.out.println(RacingCarMessages.INVALID_INPUT_EMPTY);
            return true;
        }
        return false;
    }


    public boolean isNumberInput(String input) {
        if (!input.matches("\\d+")) {
            System.out.println(RacingCarMessages.INVALID_INPUT_REPEAT);
            return false;
        }

        return true;
    }
}