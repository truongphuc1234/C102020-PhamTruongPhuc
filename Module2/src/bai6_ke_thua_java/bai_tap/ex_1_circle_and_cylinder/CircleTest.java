package bai6_ke_thua_java.bai_tap.ex_1_circle_and_cylinder;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle(5.6, "blue");
        System.out.println(circle);
        System.out.println(circle.getRadius());

        Circle circle_2 = new Circle(1.46, "yellow");
        System.out.println(circle_2);
        System.out.println(circle.getRadius());
    }
}
