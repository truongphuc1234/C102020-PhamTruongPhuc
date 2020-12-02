package bai6_ke_thua_java.thuc_hanh.ex_1_doi_tuong_hinh_hoc;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(3.5, "indigo",false);
        System.out.println(circle);
    }
}
