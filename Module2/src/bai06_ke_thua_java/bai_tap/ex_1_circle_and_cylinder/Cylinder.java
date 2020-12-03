package bai06_ke_thua_java.bai_tap.ex_1_circle_and_cylinder;

public class Cylinder extends Circle {
    private double height;

    Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return getArea()* height;
    }

    public String toString() {
        return "A cylinder with height: "
                + height
                +", which is subclass of "
                + super.toString();
    }

}
