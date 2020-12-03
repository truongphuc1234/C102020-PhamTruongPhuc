package bai09_automated_test_tdd.bai_tap.ex_3_fizz_buzz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {

    @Test
    void testTranslate0() {
        int input = 0;
        String expected = "FizzBuzz";
        String result = FizzBuzzTranslate.translate(input);
        assertEquals(result, expected);
    }

    @Test
    void testTranslate1() {
        int input = 3;
        String expected = "Fizz";
        String result = FizzBuzzTranslate.translate(input);
        assertEquals(result, expected);
    }

    @Test
    void testTranslate2() {
        int input = 5;
        String expected = "Buzz";
        String result = FizzBuzzTranslate.translate(input);
        assertEquals(result, expected);
    }

    @Test
    void testTranslate3() {
        int input = 15;
        String expected = "FizzBuzz";
        String result = FizzBuzzTranslate.translate(input);
        assertEquals(result, expected);
    }

    @Test
    void testTranslate4() {
        int input = 7;
        String expected = "bay";
        String result = FizzBuzzTranslate.translate(input);
        assertEquals(result, expected);
    }

    @Test
    void testTranslate5() {
        int input = 22;
        String expected = "hai hai";
        String result = FizzBuzzTranslate.translate(input);
        assertEquals(result, expected);
    }
}