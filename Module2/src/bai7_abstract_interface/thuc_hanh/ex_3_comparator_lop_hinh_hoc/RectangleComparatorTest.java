package bai7_abstract_interface.thuc_hanh.ex_3_comparator_lop_hinh_hoc;

import java.util.Arrays;
import java.util.Comparator;

public class RectangleComparatorTest {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[3];
        rectangles[0] = new Rectangle(10, 15);
        rectangles[1] = new Rectangle();
        rectangles[2] = new Rectangle(10, 20, "pink", true);

        System.out.println("Pre sort: ");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        Comparator rectangleComparator = new RectangleComparator();
        Arrays.sort(rectangles, rectangleComparator);

        System.out.println("After sort: ");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        Square[] squares = new Square[3];
        squares[0] = new Square(4);
        squares[1] = new Square();
        squares[2] = new Square(8, "blue", false);

        System.out.println("Pre sorted: ");
        for (Square square : squares) {
            System.out.println(square);
        }

        Arrays.sort(squares, rectangleComparator);

        System.out.println("After sorted: ");
        for (Square square : squares) {
            System.out.println(square);
        }
    }
}
