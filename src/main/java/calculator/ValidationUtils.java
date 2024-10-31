package calculator;

import calculator.message.ErrorMessages;

public class ValidationUtils {

    public static boolean isEmptyOrNull(String input) {
        return input == null || input.isEmpty();
    }

    public static int stringToInt(String input) {
        int value = 0;

        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException ex){
            throw new NumberFormatException(ErrorMessages.INVALID_INPUT);
        }

        return value;
    }

    public static void isPositiveNumber(int number){
        if (number < 0){
            throw new IllegalArgumentException(ErrorMessages.INVALID_NEGATIVE_NUMBER_INPUT);
        }
    }
}
