package racingcar.domain;

import racingcar.exception.CarException;
import racingcar.exception.messages.ErrorMessages;
import racingcar.util.RacingCarUtil;

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
            if(!Name.isNameLengthLessThanFive(carName)){
                throw new CarException(ErrorMessages.CAR_NAME_OVER_FIVE);
            }
            cars.add(new Car(carName));
        }
    }

    public String getWinnerName(){
        Location maxLocation = getMaxLocation();

        return cars.stream()
                .filter(car -> car.isWinner(maxLocation))
                .map(car -> car.getName().toString())
                .collect(Collectors.joining(", "));

    }

    public Location getMaxLocation(){
        Location maxLocation = new Location();

        for(Car car : cars){
            maxLocation = car.getMaxLocation(maxLocation);
        }

        return maxLocation;

    }

    public List<Car> getCars(){
        return List.copyOf(cars);
    }



}
