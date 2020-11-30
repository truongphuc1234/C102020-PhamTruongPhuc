package bai1_introductionJV.thuchanh.ex_3_su_dung_toan_tu;

import java.util.Scanner;

public class Operation {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter width: ");
        width = scanner.nextFloat();

        System.out.println("Enter height: ");
        height = scanner.nextFloat();

        float area = width * height;

        System.out.println("Area is: " + area);

    }
}
