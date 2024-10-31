package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StringSplitterTest {

    @Test
    @DisplayName("split 함수 콤마 포함된 경우")
    void split_comma(){
        // when
        StringSplitter splitter  = new StringSplitter("1,2");
        String[] response = splitter.split();

        assertArrayEquals(new String[]{"1", "2"}, response);
    }

    @Test
    @DisplayName("split 함수 콜론 포함된 경우")
    void split_colon(){
        // when
        StringSplitter splitter  = new StringSplitter("1:2");
        String[] response = splitter.split();


        assertArrayEquals(new String[]{"1", "2"}, response);
    }

    @Test
    @DisplayName("split 함수 콤마, 콜론 포함된 경우")
    void split_commaAndColon(){
        // when
        StringSplitter splitter  = new StringSplitter("1,2:3");
        String[] response = splitter.split();

        assertArrayEquals(new String[]{"1", "2", "3"}, response);
    }

    @Test
    @DisplayName("split 함수 사용자 지정 구분자")
    void split_customDelimiter1(){
        // when
        StringSplitter splitter = new StringSplitter("//;\n1;2;3");
        String[] response = splitter.split();

        // then
        assertArrayEquals(new String[]{"1", "2", "3"}, response);
    }

    @Test
    @DisplayName("split 함수 사용자 지정 구분자")
    void split_customDelimiter2(){
        // when
        StringSplitter splitter = new StringSplitter("//,\n1,2,3");
        String[] response = splitter.split();

        // then
        assertArrayEquals(new String[]{"1", "2", "3"}, response);
    }

    @Test
    @DisplayName("split 함수 사용자 지정 구분자")
    void split_customDelimiter3(){
        // when
        StringSplitter splitter = new StringSplitter("//;\n1,2;3");
        String[] response = splitter.split();

        for (String s : response) {
            System.out.println(s);
        }

        // then
        assertArrayEquals(new String[]{"1,2", "3"}, response);
    }

    @Test
    @DisplayName("split 함수 구분자 없어 문자열 반환")
    void split_notContainsDelimiter(){
        // when
        StringSplitter splitter = new StringSplitter("1;2;3");
        String[] response = splitter.split();

        // then
        assertArrayEquals(new String[]{"1;2;3"}, response);
    }

    @Test
    @DisplayName("구분자 포함 여부 확인 true 반환")
    void isContainsDelimiter_comma(){

        StringSplitter splitter = new StringSplitter("1,2");
        boolean response = splitter.isContainsDelimiter();

        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("구분자 포함 여부 확인 true 반환")
    void isContainsDelimiter_colon(){

        StringSplitter splitter = new StringSplitter("1:2");
        boolean response = splitter.isContainsDelimiter();

        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("구분자 포함 여부 확인 true 반환")
    void isContainsDelimiter_commaAndColon(){

        StringSplitter splitter = new StringSplitter("1,2:3");
        boolean response = splitter.isContainsDelimiter();

        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("구분자 포함 여부 확인 false 반환")
    void isContainsDelimiter_false(){

        StringSplitter splitter = new StringSplitter("12;3");
        boolean response = splitter.isContainsDelimiter();

        assertThat(response).isFalse();
    }

    @Test
    @DisplayName("사용자 지정 구분자 포함 여부 확인 true 반환")
    void isContainsCustomDelimiter_true(){
        StringSplitter splitter = new StringSplitter("//;\n1;2;3");
        boolean response = splitter.isContainsCustomDelimiter();

        assertThat(response).isTrue();
    }

    @Test
    @DisplayName("사용자 지정 구분자 포함 여부 확인 false 반환")
    void isContainsCustomDelimiter_false(){
        StringSplitter splitter = new StringSplitter("1;2;3");
        boolean response = splitter.isContainsCustomDelimiter();

        assertThat(response).isFalse();
    }



    @Test
    @DisplayName("콤마 구분자 분리")
    void splitDelimiter_comma(){

        // when
        StringSplitter splitter = new StringSplitter("1,2");
        String[] response = splitter.splitDelimiter();

        // then
        assertArrayEquals(new String[]{"1", "2"}, response);
    }

    @Test
    @DisplayName("콜론 구분자 분리")
    void splitDelimiter_colon(){

        // when
        StringSplitter splitter = new StringSplitter("1:2");
        String[] response = splitter.splitDelimiter();

        // then
        assertArrayEquals(new String[]{"1", "2"}, response);
    }

    @Test
    @DisplayName("콜론 구분자 분리")
    void splitDelimiter_commaAndColon(){

        // when
        StringSplitter splitter = new StringSplitter("1,2:3");
        String[] response = splitter.splitDelimiter();

        // then
        assertArrayEquals(new String[]{"1", "2", "3"}, response);
    }

}
