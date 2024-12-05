package racingcar.domain;

public class Car {
    private static final int FORWARD_NUM = 4;

    private Name name;
    private Location location;

    public Car(String name) {
        this.name = new Name(name);
        this.location = new Location();
    }

    public void move(int randomNum) {
        if (randomNum >= FORWARD_NUM){
            location.forward();
        }
    }

    public boolean isWinner(Location maxLocation){
        return location.equals(maxLocation);
    }

    public Location getMaxLocation(Location maxLocation) {
        return location.lessThan(maxLocation);
    }

    public Name getName(){
        return name;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return name.toString() + " : " + location.toString();
    }
}
