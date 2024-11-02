package calculator;

import calculator.utils.ValidationUtils;

import java.util.Arrays;

public class AddCalculator {
    private final String[] numbers;

    public AddCalculator(String[] numbers) {
        this.numbers = numbers;
    }

    public int add() {
        return Arrays.stream(numbers)
                .mapToInt(this::validateAndConvert)
                .sum();
    }

    public int validateAndConvert(String number){
        int num = ValidationUtils.stringToInt(number);
        ValidationUtils.isPositiveNumber(num);

        return num;
    }

}
