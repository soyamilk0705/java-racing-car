import racingcar.RacingCarGame;
import racingcar.scanner.RacingCarScanner;
import racingcar.model.RacingCars;
import racingcar.view.ResultView;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarScanner scanner = new RacingCarScanner();
        String[] result = scanner.inputCarNames();
        int repeatNum = scanner.inputRepeat();

        RacingCars cars = new RacingCars(result);
        RacingCarGame game = new RacingCarGame(cars);
        game.play(repeatNum);

        ResultView resultView = new ResultView(cars);
        resultView.printWinner();

    }
}
