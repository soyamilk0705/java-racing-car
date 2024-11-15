package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

public class ResultView {
    public static void displayRacingCars(RacingCars cars){
        for (RacingCar car : cars.getCars()){
            displayRacingCar(car);
        }
        printNewLine();
    }

    public static void displayRacingCar(RacingCar car){
        System.out.println(car.formatRacingCar());
    }

    public static void printWinner(String winnerName){
        System.out.println(winnerName + "가 최종 우승했습니다.");
    }

    public static void printNewLine(){
        System.out.println();
    }
}
