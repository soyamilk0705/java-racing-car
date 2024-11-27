package racinggame.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

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
