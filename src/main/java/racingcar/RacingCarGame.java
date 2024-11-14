package racingcar;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.ResultView;

import java.util.Map;
import java.util.Random;

public class RacingCarGame {
    private static final int FORWARD_STANDARD = 4;
    private static final int MAX_NUM = 9;

    private final RacingCars cars;
    private final Random random = new Random();

    public RacingCarGame(RacingCars cars) {
        this.cars = cars;
    }

    public void play(int repeatNum) {
        for(int i=0; i<repeatNum; i++){
            playRound();
        }
    }

    public void playRound(){
        for (RacingCar car : cars.getCars()) {
            race(car, random.nextInt(MAX_NUM) + 1);
            car.printLocation();
        }
        System.out.println();
    }


    public void race(RacingCar car, int randomNum){
        if (randomNum >= FORWARD_STANDARD){
            car.forward();
        }
    }

}

