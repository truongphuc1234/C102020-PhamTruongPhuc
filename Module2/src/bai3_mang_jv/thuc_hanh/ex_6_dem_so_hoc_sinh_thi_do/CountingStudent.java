package bai3_mang_jv.thuc_hanh.ex_6_dem_so_hoc_sinh_thi_do;

import java.util.Scanner;

public class CountingStudent {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.print("Enter a size: ");
            size = scanner.nextInt();
            if(size > 30)
                System.out.println("Size should not exceed 30");
        } while (size > 30);

        array = new int[size];
        int i = 0;
        while(i < array.length){
            System.out.print("Enter a mark for student "+(i+1)+" : ");
            array[i] = scanner.nextInt();
            i++;
        }

        int count = 0;
        System.out.print("List of mark");
        for(int j = 0; j < array.length; j ++){
            System.out.print(array[j]+"\t");
            if(array[j] >= 5 && array[j] <= 10)
                count++;
        }
        System.out.print("\n The number of students passing exam is "+count);
    }
}

