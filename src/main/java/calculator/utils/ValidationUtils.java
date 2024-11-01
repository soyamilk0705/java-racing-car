package calculator.utils;

import calculator.message.ErrorMessages;

public class ValidationUtils {
    private static final int NEGATIVE_LIMIT = 0;
    private static final int SINGLE_NUMBER_LENGTH = 1;

    public static boolean isEmptyOrNull(String input) {
        return input == null || input.isEmpty();
    }

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (RuntimeException ex){
            throw new RuntimeException(ErrorMessages.INVALID_INPUT);
        }
    }

    public static void isPositiveNumber(int number){
        if (number < NEGATIVE_LIMIT){
            throw new RuntimeException(ErrorMessages.INVALID_NEGATIVE_NUMBER_INPUT);
        }
    }

    public static boolean isSingleNumber(String[] numbers){
        return numbers.length == SINGLE_NUMBER_LENGTH;
    }

}
