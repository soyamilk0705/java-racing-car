import racingcar.domain.Race;
import racingcar.domain.Cars;
import racingcar.view.RaceResult;

public class RacingCarApplication {
    public static void main(String[] args) {
        Cars cars = new Cars("red,blue,pink");
        Race race = new Race(cars, 3);

        RaceResult raceResult = race.raceStart();
        raceResult.printWinner();
    }
}
