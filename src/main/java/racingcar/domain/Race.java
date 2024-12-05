package racingcar.domain;

import racingcar.util.RacingCarUtil;
import racingcar.view.RaceResult;

public class Race {
    private final Cars cars;
    private final int repeatNum;
    private final RaceResult raceResult;

    public Race(Cars cars, int repeatNum){
        this.cars = cars;
        this.repeatNum = repeatNum;
        this.raceResult = new RaceResult(cars);
    }

    public RaceResult raceStart(){
        for(int i=0; i<repeatNum; i++){
            race();
        }
        return raceResult;
    }

    public void race() {
        for(Car car : cars.getCars()){
            car.move(RacingCarUtil.createRandomNumber());
            raceResult.printRace(car);
        }
        System.out.println();
    }

}
