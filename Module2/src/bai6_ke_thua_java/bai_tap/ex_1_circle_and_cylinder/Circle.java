package bai6_ke_thua_java.bai_tap.ex_1_circle_and_cylinder;

public class Circle {
    private double radius;
    private String color;

    Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public String toString() {
        return "A circle with radius: "
                +radius
                +" and color: "
                +color;
    }
}
