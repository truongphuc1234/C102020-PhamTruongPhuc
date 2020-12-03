package bai04_class_object_java.bai_tap.ex_3_xay_dung_fan;

public class Execution {
    public static void main(String[] args) {
        Fan fan_1 = new Fan();
        Fan fan_2 = new Fan();

        fan_1.setSpeed(Fan.FAST);
        fan_1.setRadius(10);
        fan_1.setColor("yellow");
        fan_1.setOn(true);
        System.out.println(fan_1.toString());

        fan_2.setSpeed(Fan.MEDIUM);
        fan_2.setRadius(5);
        fan_2.setColor("blue");
        fan_2.setOn(false);
        System.out.println(fan_2.toString());

    }
}
