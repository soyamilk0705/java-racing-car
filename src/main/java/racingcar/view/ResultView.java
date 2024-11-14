package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

public class ResultView {
    private final RacingCars cars;

    public ResultView(RacingCars cars) {
        this.cars = cars;
    }

    public void printWinner() {
        for (RacingCar car : cars.getCars()){
            car.printLocation();
        }
        System.out.println("\n" + cars.getWinnerName() + "가 최종 우승했습니다.");
    }


}
