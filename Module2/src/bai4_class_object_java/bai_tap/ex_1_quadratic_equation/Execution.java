package bai4_class_object_java.bai_tap.ex_1_quadratic_equation;

import java.util.Scanner;

public class Execution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quadratic function: ax^2 + bx +c = 0.");
        System.out.println("Enter a, b ,c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        if(equation.getDiscriminant() < 0 ){
            System.out.println("The equation has no roots");
        } else if (equation.getDiscriminant() == 0) {
            System.out.println("The equation has 1 root :"+equation.getRoot1());
        } else {
            System.out.println("The equation has 2 roots: "+ equation.getRoot1() +" and "+equation.getRoot2());
        }
    }
}
