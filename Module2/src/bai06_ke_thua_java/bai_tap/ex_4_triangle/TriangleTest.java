package bai06_ke_thua_java.bai_tap.ex_4_triangle;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 3 side of triangle: ");
        double side_1 = scanner.nextDouble();
        double side_2 = scanner.nextDouble();
        double side_3 = scanner.nextDouble();

        System.out.print("Enter the color of triangle: ");
        scanner.nextLine();
        String color = scanner.nextLine();

        Triangle triangle = new Triangle(side_1, side_2, side_3, color, false);

        System.out.println(triangle);
        System.out.print("Area of the triangle: "+triangle.getArea()+"\n");
        System.out.print("Perimeter of the triangle: "+triangle.getPerimeter()+"\n");

    }
}
