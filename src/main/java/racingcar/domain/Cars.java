package racingcar.domain;

import racingcar.view.RaceResult;
import racingcar.util.RacingCarUtil;
import racingcar.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int RANDOM_NUMBER_STANDARD = 4;

    private final List<Car> cars;

    public Cars(String carNameStr) {
        this.cars = new ArrayList<>();
        createCar(carNameStr);
    }

    public void createCar(String carNameStr) {
        String[] carNames = RacingCarUtil.splitName(carNameStr);

        for (String carName : carNames){
            Validator.checkValidCarName(carName);
            cars.add(new Car(carName));
        }
    }


    public RaceResult race(int repeatNum){
        RaceResult raceResult = new RaceResult(cars);
        for(int i=0; i<repeatNum; i++){
            raceRound(raceResult);
        }

        return raceResult;
    }

    public void raceRound(RaceResult raceResult) {
        for(Car car : cars){
            int randomNumber = RacingCarUtil.createRandomNumber();
            if (randomNumber >= RANDOM_NUMBER_STANDARD){
                car.move();
            }
        }
        raceResult.printAllRaceResult();
    }



}
