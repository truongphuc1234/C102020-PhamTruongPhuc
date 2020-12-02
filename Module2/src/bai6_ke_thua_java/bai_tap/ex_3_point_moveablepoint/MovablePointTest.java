package bai6_ke_thua_java.bai_tap.ex_3_point_moveablepoint;

public class MovablePointTest {
    public static void main(String[] args) {
        MovablePoint point_1 = new MovablePoint();
        MovablePoint point_2 = new MovablePoint(2.2f,3.2f);
        MovablePoint point_3 = new MovablePoint(2.0f,4.0f,7.2f,4f);

        System.out.println(point_1);
        System.out.println(point_2);
        System.out.println(point_3);
        System.out.println("f----------------------------");
        point_2 = point_3.move();
        MovablePoint point_4 = point_2;

        System.out.println(point_2);
        System.out.println(point_3);
        System.out.println("f----------------------------");
        point_3.move();

        System.out.println(point_2);
        System.out.println(point_3);
        System.out.println(point_4);

    }
}
