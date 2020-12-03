package bai06_ke_thua_java.thuc_hanh.ex_1_doi_tuong_hinh_hoc;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8,"orange",true);
        System.out.println(rectangle);
    }
}
