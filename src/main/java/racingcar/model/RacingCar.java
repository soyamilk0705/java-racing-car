package racingcar.model;

public class RacingCar {
    private String name;
    private int location;

    public RacingCar(String name) {
        this.name = name;
        this.location = 0;
    }

    public void forward() {
        location++;
    }

    public String getName(){
        return name;
    }

    public int getLocation() {
        return location;
    }

    public String formatRacingCar() {
        return name + " : " + "-".repeat(location);
    }
}
