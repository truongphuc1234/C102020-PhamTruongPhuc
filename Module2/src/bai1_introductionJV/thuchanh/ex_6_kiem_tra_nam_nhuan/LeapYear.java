package bai1_introductionJV.thuchanh.ex_6_kiem_tra_nam_nhuan;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        boolean isLeapYear;

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0){
                    isLeapYear = true;
                } else {
                    isLeapYear = false;
                }
            } else {
                isLeapYear = true;
            }
        } else {
            isLeapYear = false;
        }

        if(isLeapYear){
            System.out.printf("%d is a leap year",year);
        } else {
            System.out.printf("%d is NOT a leap year", year);
        }
    }
}

