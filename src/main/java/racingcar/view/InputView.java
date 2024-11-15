package racingcar.view;

public class InputView {
    public static final String INPUT_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String INPUT_REPEAT_NUM_MESSAGE = "시도할 회수는 몇회인가요?";

    public static void inputCarName() {
        System.out.println(INPUT_CAR_NAME_MESSAGE);
    }

    public static void inputRepeatNum() {
        System.out.println(INPUT_REPEAT_NUM_MESSAGE);
    }
}
