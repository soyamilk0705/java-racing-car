package racingcar.validation;

import racingcar.message.ErrorMessages;

public class InputValidator {
    public static final int LIMIT_NAME_LENGTH = 5;

    public boolean checkValidInput(String[] inputArr) {
        if (isEmptyArray(inputArr)){
            System.out.println(ErrorMessages.INVALID_INPUT_CAR_NAME);
            return false;
        }

        for (String input : inputArr) {
            if (!isLessThanFiveCharacters(input)){
                System.out.println(ErrorMessages.INVALID_INPUT_CAR_NAME);
                return false;
            }
        }

        return true;
    }

    public boolean isEmptyArray(String[] inputArr) {
        return inputArr.length == 0;
    }

    public boolean isLessThanFiveCharacters(String input){
        return input.length() < LIMIT_NAME_LENGTH;
    }

    public boolean isEmptyInput(String input) {
        return input.isEmpty();
    }


    public boolean isNumberInput(String input){
        try {
            Integer.parseInt(input);
        } catch (Exception e){
            System.out.println(ErrorMessages.INVALID_INPUT_REPEAT);
            return false;
        }

        return true;
    }
}
