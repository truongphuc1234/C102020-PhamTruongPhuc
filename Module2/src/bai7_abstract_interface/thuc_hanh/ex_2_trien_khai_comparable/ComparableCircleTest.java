package bai7_abstract_interface.thuc_hanh.ex_2_trien_khai_comparable;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.6);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(3.5, "indigo", false);

        System.out.println("Pre sorted: ");
        for(Circle circle: circles){
            System.out.println(circle);
        }

        Arrays.sort(circles);

        System.out.println("After sorted: ");
        for(Circle circle: circles){
            System.out.println(circle);
        }
    }
}
