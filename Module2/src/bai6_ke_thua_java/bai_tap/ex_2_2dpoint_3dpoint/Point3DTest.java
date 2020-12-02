package bai6_ke_thua_java.bai_tap.ex_2_2dpoint_3dpoint;

public class Point3DTest {
    public static void main(String[] args) {
        Point3D point_1 = new Point3D();
        Point3D point_2 = new Point3D(1.15f, 2.35f, 2.5f);

        System.out.println(point_1);
        System.out.println(point_2);

        System.out.println(point_2.getX());
        System.out.println(point_2.getY());
        System.out.println(point_2.getZ());

        float[] xy = point_2.getXYZ();
        for(float element : xy){
            System.out.print(element +"\t");
        }

        System.out.println();

        point_2.setXYZ(1.4f, 2.4f,3.5f);

        System.out.println(point_2);
    }
}
