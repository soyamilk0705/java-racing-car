package racingcar.scanner;

import racingcar.validation.InputValidator;
import racingcar.message.ErrorMessages;

import java.util.Scanner;

public class RacingCarScanner {
    private final Scanner scanner;
    private final InputValidator validator;
    private String[] inputArr;

    public RacingCarScanner(){
        this.scanner = new Scanner(System.in);
        this.validator = new InputValidator();
    }

    public String[] inputCarNames(){
        boolean isCollect = false;

        while(!isCollect){
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String input = scanner.nextLine();

            if (validator.isEmptyInput(input)) {
                System.out.println(ErrorMessages.INVALID_INPUT_EMPTY);
                continue;
            }

            inputArr = splitComma(input);
            isCollect = validator.checkValidInput(inputArr);
        }

        return inputArr;
    }


    public int inputRepeat() {
        boolean isCollect = false;
        String repeatString = "";

        while(!isCollect){
            System.out.println("시도할 회수는 몇회인가요?");
            repeatString = scanner.nextLine();

            if (validator.isEmptyInput(repeatString)){
                System.out.println(ErrorMessages.INVALID_INPUT_EMPTY);
                continue;
            }

            isCollect = validator.isNumberInput(repeatString);
        }

        return Integer.parseInt(repeatString);

    }


    public String[] splitComma(String input) {
        return input.replaceAll(" ", "").split(",");
    }
}
