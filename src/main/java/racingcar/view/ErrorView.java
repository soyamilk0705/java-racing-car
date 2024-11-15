package racingcar.view;

public class ErrorView {
    public static final String INVALID_INPUT_CAR_NAME_MESSAGE = "이름은 5자 이하로 입력 가능합니다. 다시 입력해주세요.";
    public static final String INVALID_INPUT_EMPTY_MESSAGE = "공백은 입력할 수 없습니다. 다시 입력해주세요.";
    public static final String INVALID_INPUT_REPEAT_MESSAGE = "시도 횟수는 숫자만 입력 가능합니다.";

    public static void invalidInputCarName(){
        System.out.println(INVALID_INPUT_CAR_NAME_MESSAGE);
    }

    public static void invalidInputEmpty(){
        System.out.println(INVALID_INPUT_EMPTY_MESSAGE);
    }

    public static void invalidInputRepeat(){
        System.out.println(INVALID_INPUT_REPEAT_MESSAGE);
    }
}
