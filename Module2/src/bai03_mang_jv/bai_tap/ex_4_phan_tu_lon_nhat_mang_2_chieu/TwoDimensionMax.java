package bai03_mang_jv.bai_tap.ex_4_phan_tu_lon_nhat_mang_2_chieu;

import java.util.Scanner;

public class TwoDimensionMax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the row number of matrix: ");
        int row_size = input.nextInt();
        System.out.print("Enter the collumg number of matrix: ");
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

        int max = array[0][0];
        int col_max = 0;
        int row_max = 0;

        for (int i = 0; i < row_size; i++) {
            for (int j = 0; j < col_size; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                    col_max = j;
                    row_max = i;
                }
            }
        }

        System.out.printf("The largest value is %d at column %d and row %d", max, col_max + 1, row_max + 1);

    }
}
