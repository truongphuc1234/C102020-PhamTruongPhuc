package bai3_mang_jv.bai_tap.ex_5_gia_tri_nho_nhat;

import java.util.Scanner;

public class FindMin {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the array size: ");
        int size = input.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + " : ");
            array[i] = input.nextInt();
        }

        System.out.println("Your array: ");

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }

        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        System.out.println("The smallest number is :" + min);
    }
}
