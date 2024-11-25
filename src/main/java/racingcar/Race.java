package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.RacingCarUtil;
import racingcar.view.RaceResult;

public class Race {
    private static final int RANDOM_NUMBER_STANDARD = 4;

    private final Cars cars;
    private final int repeatNum;

    public Race(Cars cars, int repeatNum){
        this.cars = cars;
        this.repeatNum = repeatNum;
    }

    public RaceResult raceStart(){
        RaceResult raceResult = new RaceResult(cars);
        for(int i=0; i<repeatNum; i++){
            raceRound(raceResult);
        }

        return raceResult;
    }

    public void raceRound(RaceResult raceResult) {
        for(Car car : cars.getCars()){
            int randomNumber = RacingCarUtil.createRandomNumber();
            if (randomNumber >= RANDOM_NUMBER_STANDARD){
                car.move();
            }
        }
        raceResult.printAllRaceResult();
    }

}
