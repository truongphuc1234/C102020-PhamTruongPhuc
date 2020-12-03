package bai09_automated_test_tdd.bai_tap.ex_1_tinh_ngay_tiep_theo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    void testGetNextDay1() {
        int[] input = {1, 1, 2018};
        int[] expected = {2, 1, 2018};
        int[] result = NextDayCalculator.getNextDay(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testGetNextDay2() {
        int[] input = {31, 1, 2018};
        int[] expected = {1, 2, 2018};
        int[] result = NextDayCalculator.getNextDay(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testGetNextDay3() {
        int[] input = {30, 4, 2018};
        int[] expected = {1, 5, 2018};
        int[] result = NextDayCalculator.getNextDay(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testGetNextDay4() {
        int[] input = {28, 2, 2018};
        int[] expected = {1, 3, 2018};
        int[] result = NextDayCalculator.getNextDay(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testGetNextDay5() {
        int[] input = {29, 2, 2020};
        int[] expected = {1, 3, 2020};
        int[] result = NextDayCalculator.getNextDay(input);
        assertArrayEquals(expected, result);
    }

    @Test
    void testGetNextDay6() {
        int[] input = {31, 12, 2018};
        int[] expected = {1, 1, 2019};
        int[] result = NextDayCalculator.getNextDay(input);
        assertArrayEquals(expected, result);
    }

}