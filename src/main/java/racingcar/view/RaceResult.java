package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RaceResult {
    private final Cars cars;

    public RaceResult(Cars cars) {
        this.cars = cars;
    }

    public void printWinner(){
        String winnerName = cars.getWinnerName();

        for(Car car : cars.getCars()){
            printRace(car);
        }

        System.out.println("\n" + winnerName + " 가 최종 우승했습니다.");
    }

    public void printRace(Car car){
        System.out.println(car.toString());
    }

}
