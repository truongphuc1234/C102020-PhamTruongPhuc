package bai2_vong_lap_jv.thuc_hanh.ex_3_uoc_chung_lon_nhat;

import java.util.Scanner;

public class GreatCommonDivisor {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number a: ");
        a = scanner.nextInt();

        System.out.println("Enter the number b: ");
        b = scanner.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if((a == 0) ||(b== 0)){
            System.out.println("No greatest common factor");
        } else{
            while (a!= b){
                if (a>b)
                    a= a-b;
                else
                    b = b-a;
            }
            System.out.println("Greatest common factor :"+ a);
        }

    }
}
