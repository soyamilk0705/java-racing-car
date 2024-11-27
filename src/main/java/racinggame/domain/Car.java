package racinggame.domain;


import racinggame.utils.StringUtils;

import java.util.Random;

public class Car {
    private static final int FORWARD_NUM = 4;
    private static final int MAX_BOUND = 10;


    private final Name name;
    private int position = 0;
    private Position position2;

    public Car(final String name){
        this(name, 0);
    }

    public Car(String name, int position){
        // 테스트를 위해 생성자 추가 -> 나쁜 방법 아님
        this.name = new Name(name);
        this.position2 = new Position(position);
    }

    public int getPosition(){
        return position;
    }

    public Name getName(){
        return name;
    }

    public void move(MovingStrategy movingStrategy){
        if(movingStrategy.movable()){
            this.position++;
        }
    }

    public void move(int randomNo){
        if(randomNo >= FORWARD_NUM){
            position2.move();
        }
    }

    public void move(){
        if(getRandomNo() >= FORWARD_NUM){
            this.position++;
        }
    }

    protected int getRandomNo(){
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }



}
