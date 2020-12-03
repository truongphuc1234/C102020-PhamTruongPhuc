package bai09_automated_test_tdd.bai_tap.ex_2_phan_loai_tam_giac;

public class TriangleClassifier {

    public static final int EQUILATERAL = 3;
    public static final int ISOSCELES = 2;
    public static final int TRIANGLE = 1;
    public static final int NON_TRIANGLE = 0;

    public static int classifyTriangle(double[] sides) {
        if ((sides[0] + sides[1] > sides[2]) && (sides[1] + sides[2] > sides[0]) && (sides[0] + sides[2] > sides[1])) {
            if ((sides[0] == sides[1]) && (sides[0] == sides[2])) {
                return EQUILATERAL;
            } else if ((sides[0] == sides[1]) || (sides[1] == sides[2]) || (sides[0] == sides[2])) {
                return ISOSCELES;
            } else
                return TRIANGLE;
        } else
            return NON_TRIANGLE;
    }
}
