package bai6_ke_thua_java.bai_tap.ex_4_triangle;

public class Shape {
    private String color = "yellow";
    private boolean filled = false;

    Shape() {
    }

    Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "a shape with color "+color+" and "+((filled)? "not filled": "filled");
    }
}
