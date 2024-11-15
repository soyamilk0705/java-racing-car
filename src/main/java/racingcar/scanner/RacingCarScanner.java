package racingcar.scanner;

import racingcar.validation.InputValidator;
import racingcar.view.ErrorView;
import racingcar.view.InputView;

import java.util.Scanner;

public class RacingCarScanner {
    private final Scanner scanner;
    private final InputValidator validator;

    public RacingCarScanner(){
        this.scanner = new Scanner(System.in);
        this.validator = new InputValidator();
    }

    public String[] inputCarNames(){
        while (true) {
            InputView.inputCarName();
            String input = scanner.nextLine();

            if (validator.isEmptyInput(input)) {
                continue;
            }

            String[] inputArr = splitComma(input);
            if (validator.isValidCarName(inputArr)){
                return inputArr;
            }

            ErrorView.invalidInputCarName();
        }
    }


    public int inputRepeat() {
        while(true){
            InputView.inputRepeatNum();
            String repeatString = scanner.nextLine();

            if (validator.isEmptyInput(repeatString)){
                continue;
            }

            if (validator.isNumberInput(repeatString)){
                return Integer.parseInt(repeatString);
            }
        }
    }


    public String[] splitComma(String input) {
        return input.replaceAll(" ", "").split(",");
    }
}
