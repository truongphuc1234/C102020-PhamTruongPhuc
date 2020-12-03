package bai01_introductionJV.thuchanh.ex_4_giai_phuong_trinh_bac_nhat;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver: ");
        System.out.println("Given a equation as 'ax + b = 0' , please enter constants: ");

        Scanner scanner = new Scanner(System.in);

        System.out.println("a: ");
        double a = scanner.nextDouble();

        System.out.println("b: ");
        double b = scanner.nextDouble();

        if (a != 0) {
            double solution = -b/a;
            System.out.printf("The solution is: %f !", solution);
        } else {
            if (b == 0){
                System.out.println("The solution is all x!");
            } else {
                System.out.println("No solution !");
            }
        }
    }
}
