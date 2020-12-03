package bai09_automated_test_tdd.thuc_hanh.ex_2_absolute_number_calculator;

public class AbsoluteNumberCalculator {
    public static int findAbsolute(int number) {
        if(number < 0)
            return -number;
        else
            return number;
    }
}
