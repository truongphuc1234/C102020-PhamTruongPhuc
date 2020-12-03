package bai03_mang_jv.bai_tap.ex_6_tong_cac_so_trong_cot;

import java.util.Scanner;

public class SumColumn {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the row number of matrix: ");
        int row_size = input.nextInt();
        System.out.print("Enter the column number of matrix: ");
        int col_size = input.nextInt();

        int[][] array = new int[row_size][col_size];

        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                System.out.printf("Enter the element row %d  and colunm %d :", i + 1, j + 1);
                array[i][j] = input.nextInt();
            }
        }

        System.out.println("Your array: ");
        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("");
        }

        int col_index;
        do {
            System.out.print("Enter the column need calculate: ");
            col_index = input.nextInt();
            if((col_index < 0) || (col_index > col_size - 1)){
                System.out.println("Invalid column index");
            }
        } while ((col_index < 0) || (col_index > col_size - 1));

        int sum = 0;
        for (int i = 0; i <row_size; i ++){
            sum +=array[i][col_index];
        }

        System.out.println("The sum of column " +col_index+" is : "+sum);
    }
}
