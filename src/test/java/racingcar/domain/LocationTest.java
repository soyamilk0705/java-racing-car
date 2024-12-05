package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {

    @Test
    @DisplayName("Location 비교")
    void lessThan(){
        // given
        Location maxLocation = new Location(3);
        Location lessLocation = new Location(2);

        // when
        Location response = lessLocation.lessThan(maxLocation);

        // then
        assertThat(response).isEqualTo(maxLocation);
    }

    @Test
    @DisplayName("자동차 이름이 5글자가 넘지 않아 true 반환")
    void isNameLengthLessThanFive_true(){
        // given, when
        boolean response = Name.isNameLengthLessThanFive("blue");

        // then
        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("자동차 이름이 5글자가 넘어 false 반환")
    void isNameLengthLessThanFive_false(){
        // given, when
        boolean response = Name.isNameLengthLessThanFive("green");

        // then
        assertThat(response).isFalse();
    }
}