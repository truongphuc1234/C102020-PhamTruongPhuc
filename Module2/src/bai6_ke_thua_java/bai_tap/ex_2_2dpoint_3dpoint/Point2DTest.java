package bai6_ke_thua_java.bai_tap.ex_2_2dpoint_3dpoint;

public class Point2DTest {
    public static void main(String[] args) {
        Point2D point_1 = new Point2D();
        Point2D point_2 = new Point2D(1.15f, 2.35f);

        System.out.println(point_1);
        System.out.println(point_2);

        System.out.println(point_2.getX());
        System.out.println(point_2.getY());

        float[] xy = point_2.getXY();
        for(float element : xy){
            System.out.print(element +"\t");
        }

        point_2.setXY(1.4f, 2.4f);

        System.out.println(point_2);
    }
}
