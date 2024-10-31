package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        if (ValidationUtils.isEmptyOrNull(input)){
            return 0;
        }

        StringSplitter splitter = new StringSplitter(input);
        String[] stringNumbers = splitter.split();

        AddCalculator calculator = new AddCalculator(stringNumbers);
        return calculator.sum();

    }

}
