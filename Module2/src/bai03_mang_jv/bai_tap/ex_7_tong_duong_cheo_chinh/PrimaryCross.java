package bai03_mang_jv.bai_tap.ex_7_tong_duong_cheo_chinh;

import java.util.Scanner;

public class PrimaryCross {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the size: ");
        int size = input.nextInt();

        double[][] array = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("Enter element at column %d and row %d :", j, i);
                array[i][j] = input.nextDouble();
            }
        }

        System.out.println("Your array:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("");
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += array[i][i];
        }

        System.out.println("Sum of primary cross is: "+sum);
    }
}

