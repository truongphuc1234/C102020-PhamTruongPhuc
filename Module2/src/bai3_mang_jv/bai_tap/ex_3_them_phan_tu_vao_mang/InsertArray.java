package bai3_mang_jv.bai_tap.ex_3_them_phan_tu_vao_mang;

import java.util.Scanner;

public class InsertArray {
    public static void main(String[] args) {
        int size;
        int[] array = new int[20];
        Scanner input = new Scanner(System.in);

        do{
            System.out.println("Enter array size: ");
            size = input.nextInt();
        } while (size >= 20);

        for (int i = 0; i < size; i ++){
            System.out.print("Enter the "+(i+1)+ " element: ");
            array[i] = input.nextInt();
        }

        for(int i = 0; i < array.length; i ++) {
            System.out.print(array[i] +"\t");
        }

        System.out.print("Enter the insert value: ");
        int insert_value = input.nextInt();

        System.out.print("Enter the insert index");
        int insert_index = input.nextInt();

        if((insert_index >= array.length-1) || (insert_index <= 1)){
            System.out.println("Cant not insert this value");
        }else {
            for (int i = size; i > insert_index; i--) {
                array[i] = array[i - 1];
            }
            array[insert_index] = insert_value;

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + "\t");
            }
        }
    }
}
