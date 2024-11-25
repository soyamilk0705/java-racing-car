package racingcar.domain;

import racingcar.view.RaceResult;
import racingcar.util.RacingCarUtil;
import racingcar.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
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

    public List<Car> getCars(){
        return List.copyOf(cars);
    }

    public String getWinnerName(){
        int winnerLocation = cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);


        return cars.stream()
                .filter(car -> car.getLocation() == winnerLocation)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }




}
