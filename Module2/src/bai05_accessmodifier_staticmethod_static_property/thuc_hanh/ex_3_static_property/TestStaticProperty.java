package bai05_accessmodifier_staticmethod_static_property.thuc_hanh.ex_3_static_property;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1 = new Car("Mazda 3","Skyactiv 3");
        System.out.println(Car.numberOfCars);

        Car car2 = new Car("Mazda 3","Skyactiv 3");
        System.out.println(Car.numberOfCars);
    }
}
