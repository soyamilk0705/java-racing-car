package racinggame.domain;

import java.util.Objects;

public class Position {
    private int position;

    public Position(){
        this(0);
    }

    public Position(int position) {
        if (position < 0){
            throw new IllegalArgumentException("position은 음수 값을 가질 수 없습니다.");
        }
        this.position = position;
    }

    public Position move() {
        position = position + 1;
        return this;
    }

    public Position move2() {
        return new Position(position + 1);
    }

    public void move3() {
        position = position + 1;
    }

    public int getPosition(){
        // move3로 구현할 경우 getter 를 만들어야함
        // move2 = move3 + getPosition
        // 어느게 맞다는 없음
        return position;
    }

    public boolean isSame(int maxPosition) {
        return this.position == maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }

    public boolean lessThan(Position maxPosition) {
        return false;
    }
}
