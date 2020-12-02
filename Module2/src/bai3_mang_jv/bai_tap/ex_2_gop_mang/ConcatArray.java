package bai3_mang_jv.bai_tap.ex_2_gop_mang;

import java.util.Scanner;

public class ConcatArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the 1st array size: ");
        int size_1 = input.nextInt();
        int[] array_1 = new int[size_1];

        for (int i = 0; i < size_1; i++) {
            System.out.print("Enter the " + (i + 1) + " element of 1st array: ");
            array_1[i] = input.nextInt();
        }

        System.out.print("Enter the 2nd array size: ");
        int size_2 = input.nextInt();
        int[] array_2 = new int[size_2];

        for (int i = 0; i < size_2; i++) {
            System.out.print("Enter the " + (i + 1) + " element of 2st array: ");
            array_2[i] = input.nextInt();
        }

        System.out.println("First Array: ");
        for (int i = 0; i < array_1.length; i++) {
            System.out.print(array_1[i] + "\t");
        }
        System.out.println("");

        System.out.println("Second Array: ");
        for (int i = 0; i < array_2.length; i++) {
            System.out.print(array_2[i] + "\t");
        }
        System.out.println("");

        int size_3 = size_1 + size_2;
        int[] array_3 = new int[size_3];

        for (int i = 0; i < array_1.length; i++) {
            array_3[i] = array_1[i];
        }
        for (int i = 0; i < array_2.length; i++) {
            array_3[array_1.length + i] = array_2[i];
        }

        System.out.println("Third Array: ");
        for (int i = 0; i < array_3.length; i++) {
            System.out.print(array_3[i] + "\t");
        }
    }
}
