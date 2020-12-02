package bai6_ke_thua_java.bai_tap.ex_3_point_moveablepoint;

public class PointTest {
    public static void main(String[] args) {
        Point point_1 = new Point();
        Point point_2 = new Point(1.15f, 2.35f);

        System.out.println(point_1);
        System.out.println(point_2);

        System.out.println(point_2.getX());
        System.out.println(point_2.getY());

        float[] xy = point_2.getXY();
        for (float element : xy) {
            System.out.print(element + "\t");
        }

        System.out.println();

        point_2.setXY(1.4f, 2.4f);

        System.out.println(point_2);
    }
}
