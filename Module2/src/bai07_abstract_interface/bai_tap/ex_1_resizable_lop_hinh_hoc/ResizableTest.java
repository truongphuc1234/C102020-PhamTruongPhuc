package bai07_abstract_interface.bai_tap.ex_1_resizable_lop_hinh_hoc;

public class ResizableTest {
    public static void main(String[] args) {

        Circle circle = new Circle(3.0);
        Rectangle rectangle = new Rectangle(4,5);
        Square square = new Square(3);

        System.out.println("Before resizable: ");
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);

        circle.resize(10);
        rectangle.resize(10);
        square.resize(10);

        System.out.println("After resizable: ");
        System.out.println(circle);
        System.out.println(rectangle);
        System.out.println(square);

    }
}
