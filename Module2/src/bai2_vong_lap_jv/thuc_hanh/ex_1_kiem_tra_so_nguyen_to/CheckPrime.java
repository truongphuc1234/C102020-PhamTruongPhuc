package bai2_vong_lap_jv.thuc_hanh.ex_1_kiem_tra_so_nguyen_to;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if( number < 2) {
            System.out.println(number +" is NOT a prime");
        }
        else {
            int i = 2;
            boolean check = true;
            while (i < Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if(check) {
                System.out.println(number + " is a prime");
            }else {
                System.out.println(number + " is NOT a prime");
            }
        }

    }
}
