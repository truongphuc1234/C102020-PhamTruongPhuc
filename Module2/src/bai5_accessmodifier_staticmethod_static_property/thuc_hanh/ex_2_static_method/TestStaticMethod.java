package bai5_accessmodifier_staticmethod_static_property.thuc_hanh.ex_2_static_method;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();

        //create student
        Student s1 = new Student(111,"Hoang");
        Student s2 = new Student(222,"Khanh");
        Student s3 = new Student(333,"Nam");

        //calling display method
        s1.display();
        s2.display();
        s3.display();
    }
}
