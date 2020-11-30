package bai4_class_object_java.bai_tap.ex_3_xay_dung_fan;

public class Fan {
    static final int SLOW = 1;
    static final int MEDIUM = 2;
    static final int FAST = 3;

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5.0;
        this.color = "blue";
    }

    public String toString() {
        String information = "";
        if (this.on){
            information= "Fan is on. Speed: "+this.speed+". Color: "+this.color+". Radius: "+this.radius;
        }else {
            information = "Fan is off. Color: "+this.color+". Radius: "+this.radius;
        }
        return information;
    }

    public double getRadius() {
        return this.radius;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getColor() {
        return this.color;
    }

    public boolean getOn() {
        return this.on;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
