package bai07_abstract_interface.bai_tap.ex_2_colorable;

public class TestColorable {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0]= new Circle(3.5);
        shapes[1]= new Rectangle(4.5,3.5);
        shapes[2]= new Square(2.5);

        for(Shape shape : shapes){
            if (shape instanceof Circle){
                System.out.println(((Circle) shape).getArea());
            }else if( shape instanceof Rectangle){
                System.out.println(((Rectangle) shape).getArea());
            }else {
                System.out.println(((Square) shape).getArea());
            }

            if (shape instanceof Colorable){
                ((Colorable) shape).howToColor();
            }
        }

    }
}
