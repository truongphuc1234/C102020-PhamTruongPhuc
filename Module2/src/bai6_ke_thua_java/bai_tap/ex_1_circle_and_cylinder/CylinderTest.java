package bai6_ke_thua_java.bai_tap.ex_1_circle_and_cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(3.5,"blue",4.6);

        System.out.println(cylinder.getVolume());
        System.out.println(cylinder.getArea());
        System.out.println(cylinder.getHeight());
        cylinder.setHeight(3.2);
        System.out.println(cylinder);
    }
}
