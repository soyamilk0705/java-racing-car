package racingcar;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

public class RacingCarGame {
    private static final int FORWARD_STANDARD = 4;
    private final RacingCars cars;
    private final RacingCarRandom random;

    public RacingCarGame(RacingCars cars) {
        this.cars = cars;
        this.random = new RacingCarRandom();
    }

    public void play(int repeatNum) {
        for(int i=0; i<repeatNum; i++){
            for (RacingCar car : cars.getCars()) {
                race(car, random.createRandomNum());
            }
            cars.printCars();
        }
    }


    public void race(RacingCar car, int randomNum){
        if (randomNum >= FORWARD_STANDARD){
            car.forward();
        }
    }

    public void winner() {
        cars.printCars();
        System.out.println(cars.getWinnerName() + "가 최종 우승했습니다.");
    }
}

