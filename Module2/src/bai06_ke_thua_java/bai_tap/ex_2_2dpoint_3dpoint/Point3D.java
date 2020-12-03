package bai06_ke_thua_java.bai_tap.ex_2_2dpoint_3dpoint;

public class Point3D extends Point2D {
    private float z;

    Point3D() {

    }

    Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ(){
        float[] array = {getX(),getY(),z};
        return array;
    }

    @Override
    public String toString() {
        return "("
                +getX()
                +", "
                +getY()
                +", "
                +getZ()
                +")";
    }
}
