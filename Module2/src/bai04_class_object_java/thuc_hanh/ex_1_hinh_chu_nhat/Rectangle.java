package bai04_class_object_java.thuc_hanh.ex_1_hinh_chu_nhat;

public class Rectangle {
    double width, height;

    public Rectangle() {

    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    public String display() {
        return "Rectangle{width = " + width + ", height = " + height + "}";
    }
}


