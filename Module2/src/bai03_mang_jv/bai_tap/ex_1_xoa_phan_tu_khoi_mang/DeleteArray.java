package bai03_mang_jv.bai_tap.ex_1_xoa_phan_tu_khoi_mang;


import java.util.Scanner;

public class DeleteArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int size;
        int[] array;

        System.out.print("Enter array size: ");
        size = input.nextInt();

        array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter the " + (i + 1) + " element: ");
            array[i] = input.nextInt();
        }

        for ( int i = 0; i < array.length; i ++){
            System.out.print(array[i] + "\t");
        }

        System.out.print("Enter the deleted element: ");
        int delete_element = input.nextInt();

        int index = -1;

        for (int i = 0; i <array.length; i ++){
            if( array[i] == delete_element){
                index = i;
                break;
            }
        }
        if(index == -1){
            System.out.println("No such value in array");
        } else {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[array.length - 1] = 0;

            for ( int i = 0; i < array.length; i ++){
                System.out.print(array[i] + "\t");
            }
        }
    }
}
