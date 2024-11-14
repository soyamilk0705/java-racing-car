package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<RacingCar> cars;

    public RacingCars(String[] carNames){
        cars = new ArrayList<>();

        for (String carName : carNames) {
            RacingCar car = new RacingCar(carName);
            cars.add(car);
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    public String getWinnerName() {
        int winnerLocation = cars.stream()
                .mapToInt(RacingCar::getLocation)
                .max()
                .orElse(0);


        return cars.stream()
                .filter(car -> car.getLocation() == winnerLocation)
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
    }



}
