package racingcar.domain;

import java.util.Objects;

public class Location {
    private int location;

    public Location(){
        this.location = 0;
    }

    public Location(int location){
        this.location = location;
    }

    public void forward(){
        location++;
    }

    public Location lessThan(Location maxLocation) {
        if (location > maxLocation.location){
            return this;
        }
        return maxLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location1 = (Location) o;
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(location);
    }

    @Override
    public String toString() {
        return "-".repeat(location);
    }
}
