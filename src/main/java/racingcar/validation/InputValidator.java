package racingcar.validation;

import racingcar.view.ErrorView;

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
            ErrorView.invalidInputEmpty();
            return true;
        }
        return false;
    }


    public boolean isNumberInput(String input) {
        if (!input.matches("\\d+")) {
            ErrorView.invalidInputRepeat();
            return false;
        }

        return true;
    }
}
