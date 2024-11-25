import racingcar.domain.Cars;
import racingcar.view.RaceResult;

public class RacingCarApplication {
    public static void main(String[] args) {
        Cars cars = new Cars("red,blue,pink");
        RaceResult raceResult = cars.race(3);
        raceResult.printAllRaceResult();
        raceResult.printWinner();
    }
}
