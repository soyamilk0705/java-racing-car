package calculator;

public class AddCalculator {
    private final String[] numbers;

    public AddCalculator(String[] stringNumbers) {
        this.numbers = stringNumbers;
    }

    public int sum() {
        int result = 0;

        for (String number : numbers) {
            int num = ValidationUtils.stringToInt(number);
            ValidationUtils.isPositiveNumber(num);

            result += num;
        }

        return result;
    }


}
