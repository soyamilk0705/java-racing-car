package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> findWinner() {
        // return findWinners(this.cars, getMaxPosition());
        return findWinners(getMaxPosition());
    }

    private static List<Car> findWinners(List<Car> cars, Position maxPosition) {
        // 인수값으로 테스트가 가능하므로 테스트하기 간편해짐(Cars 객체를 만들지 않아도됨)
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)){
                winners.add(car);
            }
        }
        return winners;
    }


    private List<Car> findWinners(Position maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)){
                winners.add(car);
            }
        }
        return winners;
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars){
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

}
