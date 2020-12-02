package bai3_mang_jv.bai_tap.ex_8_dem_ki_tu;

import java.util.Scanner;

public class CountingCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        System.out.print("Enter a character: ");
        char inputChar = scanner.next().charAt(0);

        int count = 0;
        for(int i = 0; i < inputString.length(); i++){
            if (inputChar == inputString.charAt(i))
                count++;
        }

        System.out.printf("Character %s appear %d time(s)",inputChar,count);

    }
}

