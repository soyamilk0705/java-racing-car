package racingcar.scanner;

import racingcar.validation.InputValidator;
import racingcar.message.RacingCarMessages;

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
            String input = getInputWithMessage(RacingCarMessages.INPUT_CAR_NAMES);

            if (validator.isEmptyInput(input)) {
                continue;
            }

            String[] inputArr = splitComma(input);

            if (validator.isValidCarName(inputArr)){
                return inputArr;
            }

            System.out.println(RacingCarMessages.INVALID_INPUT_CAR_NAME);

        }
    }


    public int inputRepeat() {
        String repeatString;

        while(true){
            repeatString = getInputWithMessage(RacingCarMessages.INPUT_REPEAT_NUM);

            if (validator.isEmptyInput(repeatString)){
                continue;
            }

            if (validator.isNumberInput(repeatString)){
                return Integer.parseInt(repeatString);
            }
        }
    }

    public String getInputWithMessage(String message){
        System.out.println(message);
        return scanner.nextLine();
    }


    public String[] splitComma(String input) {
        return input.replaceAll(" ", "").split(",");
    }
}
