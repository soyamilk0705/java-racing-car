package calculator;

import calculator.utils.ValidationUtils;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (ValidationUtils.isEmptyOrNull(input)) return 0;

        String[] numbers = inputSplit(input);

        if (ValidationUtils.isSingleNumber(numbers)) {
            return ValidationUtils.stringToInt(numbers[0]);
        }

        return new AddCalculator(numbers).add();
    }

    public static String[] inputSplit(String input){
        return new StringSplitter(input).split();
    }

}
