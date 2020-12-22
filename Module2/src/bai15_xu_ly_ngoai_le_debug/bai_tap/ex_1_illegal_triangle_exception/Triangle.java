package bai15_xu_ly_ngoai_le_debug.bai_tap.ex_1_illegal_triangle_exception;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        System.out.println("Nhap 3 canh tam giac: ");
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        if (a <= 0 || b <= 0 || c <= 0|| a+b<c||b+c<a||c+a<b)
            throw new IllegalTriangleException();
    }
}
