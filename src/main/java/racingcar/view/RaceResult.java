package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
    private final List<Car> cars;

    public RaceResult(List<Car> cars) {
        this.cars = cars;
    }

    public void printAllRaceResult(){
        for(Car car : cars){
            System.out.println(drawRaceResult(car));
        }
        System.out.println();
    }

    public String drawRaceResult(Car car){
        return car.getName() + " : " + "-".repeat(car.getLocation());
    }

    public void printWinner(){
        int winnerLocation = cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);


        String winnerName = cars.stream()
                .filter(car -> car.getLocation() == winnerLocation)
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(winnerName + "가 최종 우승했습니다.");

    }


}
