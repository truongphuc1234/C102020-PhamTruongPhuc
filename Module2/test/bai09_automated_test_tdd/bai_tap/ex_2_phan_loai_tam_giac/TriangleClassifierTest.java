package bai09_automated_test_tdd.bai_tap.ex_2_phan_loai_tam_giac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    public static final int EQUILATERAL = 3;
    public static final int ISOSCELES = 2;
    public static final int TRIANGLE = 1;
    public static final int NON_TRIANGLE = 0;

    @Test
    void TestClassifyTriangle0() {
        double[] input = {2, 2, 2};
        int expected = EQUILATERAL;
        int result = TriangleClassifier.classifyTriangle(input);
        assertEquals(expected, result);
    }
    @Test
    void TestClassifyTriangle1() {
        double[] input = {2, 2, 3};
        int expected = ISOSCELES;
        int result = TriangleClassifier.classifyTriangle(input);
        assertEquals(expected, result);
    }
    @Test
    void TestClassifyTriangle2() {
        double[] input = {3, 4, 5};
        int expected = TRIANGLE;
        int result = TriangleClassifier.classifyTriangle(input);
        assertEquals(expected, result);
    }
    @Test
    void TestClassifyTriangle3() {
        double[] input = {8, 2, 3};
        int expected = NON_TRIANGLE;
        int result = TriangleClassifier.classifyTriangle(input);
        assertEquals(expected, result);
    }
    @Test
    void TestClassifyTriangle4() {
        double[] input = {-1, 2, 1};
        int expected = NON_TRIANGLE;
        int result = TriangleClassifier.classifyTriangle(input);
        assertEquals(expected, result);
    }
   @Test
    void TestClassifyTriangle5() {
        double[] input = {0, 1, 1};
        int expected = NON_TRIANGLE;
        int result = TriangleClassifier.classifyTriangle(input);
        assertEquals(expected, result);
    }

}