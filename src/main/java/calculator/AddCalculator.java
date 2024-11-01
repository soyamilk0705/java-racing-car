package calculator;

import calculator.utils.ValidationUtils;

public class AddCalculator {
    private final String[] numbers;

    public AddCalculator(String[] numbers) {
        this.numbers = numbers;
    }

    public int add() {
        int result = 0;

        for (String number : numbers) {
            int num = validateAndConvert(number);
            result += num;
        }

        return result;
    }

    public int validateAndConvert(String number){
        int num = ValidationUtils.stringToInt(number);
        ValidationUtils.isPositiveNumber(num);

        return num;
    }

}
