package bai05_accessmodifier_staticmethod_static_property.bai_tap.ex_1_access_modifier;

public class TestClassCircle {
    public static void main(String[] args) {
        Circle circle_1 = new Circle();
        Circle circle_2 = new Circle(2.4);

        System.out.println(circle_1.getArea());
        System.out.println(circle_1.getRadius());

        System.out.println(circle_2.getArea());
        System.out.println(circle_2.getRadius());

    }
}
