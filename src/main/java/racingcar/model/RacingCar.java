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

    @Override
    public String toString() {
        return name + " : " + drawLocation(location);
    }

    public String drawLocation(int location) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<location; i++){
            sb.append("-");
        }

        return sb.toString();
    }


}
