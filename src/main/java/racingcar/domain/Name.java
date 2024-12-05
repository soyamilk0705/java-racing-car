package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final int CAR_NAME_MAX = 5;

    private String name;

    public Name(String name){
        this.name = name;
    }

    public static boolean isNameLengthLessThanFive(String name) {
        return name.length() < CAR_NAME_MAX;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
