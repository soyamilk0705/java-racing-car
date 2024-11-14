package racingcar.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private InputValidator validator;

    @BeforeEach
    void setUp(){
        validator = new InputValidator();
    }

    @Test
    @DisplayName("자동차 이름을 담은 배열이 빈값으로 false 리턴")
    void isValidCarName_EmptyArray(){
        // given, when
        boolean response = validator.isValidCarName(new String[]{});

        // then
        assertFalse(response);
    }

    @Test
    @DisplayName("자동차 이름을 담은 배열이 빈값이 아니여서 false 리턴")
    void isValidCarName_NotEmptyArray(){
        // given, when
        boolean response = validator.isEmptyArray(new String[]{"red"});

        // then
        assertFalse(response);
    }


    @Test
    @DisplayName("자동차 이름들 중 5자 미만으로만 구성되어 있어 true 리턴")
    void isValidCarName_lessThanFiveCharacters(){
        // given, when
        boolean response = validator.isValidCarName(new String[]{"red", "blue", "pink"});

        // then
        assertTrue(response);
    }

    @Test
    @DisplayName("자동차 이름들 중 5자 이상이 포함되어 있어서 false 리턴")
    void isValidCarName_MoreFiveCharacters(){
        // given, when
        boolean response = validator.isValidCarName(new String[]{"red", "purple", "green"});

        // then
        assertFalse(response);
    }

    @Test
    @DisplayName("자동차 이름을 담은 배열이 빈값으로 true 리턴")
    void isEmptyArray(){
        // given, when
        boolean response = validator.isEmptyArray(new String[]{});

        // then
        assertTrue(response);
    }

    @Test
    @DisplayName("자동차 이름을 담은 배열이 빈값이 아니여서 false 리턴")
    void isNotEmptyArray(){
        // given, when
        boolean response = validator.isEmptyArray(new String[]{"red"});

        // then
        assertFalse(response);
    }


    @Test
    @DisplayName("자동차 이름이 5자 이상인지 확인 후 true 리턴")
    void isLessThanFiveCharactersTrue(){
        // given, when
        boolean response = validator.isLessThanFiveCharacters("red");

        // then
        assertTrue(response);
    }

    @Test
    @DisplayName("자동차 이름이 5자 이상이여서 false 리턴")
    void isLessThanFiveCharactersFalse(){
        // given, when
        boolean response = validator.isLessThanFiveCharacters("purple");

        // then
        assertFalse(response);
    }


    @Test
    @DisplayName("입력값이 빈값으로 true 반환")
    void isEmptyInputTrue(){
        // given, when
        boolean response = validator.isEmptyInput("");

        // then
        assertTrue(response);
    }


    @Test
    @DisplayName("입력값이 빈값이 아니여서 false 반환")
    void isEmptyInputFalse(){
        // given, when
        boolean response = validator.isEmptyInput("red");

        // then
        assertFalse(response);
    }

    @Test
    @DisplayName("반복횟수 입력 시 숫자 문자열 입력으로 true 반환")
    void isNumberInput(){
        // given, when
        boolean response = validator.isNumberInput("3");

        // then
        assertTrue(response);
    }

    @Test
    @DisplayName("반복횟수 입력 시 숫자 아닌 문자열 입력으로 false 반환")
    void isNotNumberInput(){
        // given, when
        boolean response = validator.isNumberInput("테스트");

        // then
        assertFalse(response);
    }

}