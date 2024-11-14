package racingcar.scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarScannerTest {

    private RacingCarScanner scanner;

    @BeforeEach
    void setUp(){
        scanner = new RacingCarScanner();
    }

    @Test
    @DisplayName("자동차 이름 쉼표로 구분")
    void splitComma(){
        // given, when
        String[] response = scanner.splitComma("red,blue,green");

        // then
        assertArrayEquals(response, new String[]{"red", "blue", "green"});
    }

    @Test
    @DisplayName("자동차 이름 쉼표로 구분 시 공백 포함되어 있을 경우")
    void splitCommaContainsSpace(){
        // given, when
        String[] response = scanner.splitComma("red, blue,       green");

        // then
        assertArrayEquals(response, new String[]{"red", "blue", "green"});
    }


    @Test
    @DisplayName("자동차 이름 쉼표로 구분 시 쉼표가 없는 경우")
    void splitCommaNotContainsComma(){
        // given, when
        String[] response = scanner.splitComma("red@b");

        // then
        assertArrayEquals(response, new String[]{"red@b"});
    }







}
