package bai2_vong_lap_jv.bai_tap.ex_1_hien_thi_cac_hinh;

import java.util.Scanner;

public class DrawImage {
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter your choice: \n1. Print the rectangle\n2. Print the square triangle\n3. Print isosceles triangle\n4. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the height: ");
                    int height = scanner.nextInt();
                    System.out.println("Enter the width: ");
                    int width = scanner.nextInt();
                    for( int i = 0; i < height; i++){
                        for (int j = 0; j < width;j++){
                            System.out.print('*');
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Enter the length: ");
                    int length = scanner.nextInt();
                    for(int i = 1;i <= length; i ++){
                        for (int j = 0; j < i; j ++){
                            System.out.print('*');
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Enter the length: ");
                    length = scanner.nextInt();
                    for(int i = length;i >= 1; i --){
                        for (int j = 0; j < i; j ++){
                            System.out.print('*');
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("No such choice!");
                    break;
            }
        } while (choice != 4);
    }
}
