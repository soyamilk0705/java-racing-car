package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RaceResult {
    private final Cars cars;

    public RaceResult(Cars cars) {
        this.cars = cars;
    }

    public void printAllRaceResult(){
        for(Car car : cars.getCars()){
            System.out.println(drawRaceResult(car));
        }
        System.out.println();
    }

    public String drawRaceResult(Car car){
        return car.getName() + " : " + "-".repeat(car.getLocation());
    }

    public void printWinner(){
        String winnerName = cars.getWinnerName();

        System.out.println(winnerName + "가 최종 우승했습니다.");

    }


}
