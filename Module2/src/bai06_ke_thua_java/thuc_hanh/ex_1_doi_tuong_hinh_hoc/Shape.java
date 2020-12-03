package bai06_ke_thua_java.thuc_hanh.ex_1_doi_tuong_hinh_hoc;

public class Shape {
    private String color = "green";
    private boolean filled = true;

    Shape() {
    }

    Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A shape with color "
                +getColor()
                +" and "
                + (isFilled()? "filled":"not filled");
    }
}
