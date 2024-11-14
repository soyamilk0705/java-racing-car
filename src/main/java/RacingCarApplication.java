import racingcar.RacingCarGame;
import racingcar.scanner.RacingCarScanner;
import racingcar.model.RacingCars;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarScanner scanner = new RacingCarScanner();
        String[] result = scanner.inputCarNames();
        int repeatNum = scanner.inputRepeat();

        RacingCars cars = new RacingCars(result);
        RacingCarGame game = new RacingCarGame(cars);
        game.play(repeatNum);
        game.winner();


    }
}
