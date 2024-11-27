package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    public void 이동1(){
        Car car = new Car("pobi"){
            @Override
            protected int getRandomNo(){
                return 4;
            }
        };
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 정지1(){
        Car car = new Car("pobi"){
            @Override
            protected int getRandomNo(){
                return 3;
            }
        };
        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 이동2(){
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 정지2(){
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 이동3(){
        Car car = new Car("pobi");
        car.move(new MovingStrategy() {
            @Override
            public boolean movable() {
                return true;
            }
        });
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 정지3(){
        Car car = new Car("pobi");
        car.move(new MovingStrategy() {
            @Override
            public boolean movable() {
                return false;
            }
        });
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    public void 이동4(){
        Car car = new Car("pobi");
        // 인터페이스에 메서드가 하나여야지만 람다식으로 사용 가능
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 정지4(){
        Car car = new Car("pobi");
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
