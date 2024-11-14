import racingcar.RacingCarGame;
import racingcar.model.RacingCars;
import racingcar.scanner.RacingCarScanner;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarScanner scanner = new RacingCarScanner();

        RacingCars cars = new RacingCars(scanner.inputCarNames());

        RacingCarGame game = new RacingCarGame(cars);
        game.play(scanner.inputRepeat());
        game.printWinner();


    }
}
