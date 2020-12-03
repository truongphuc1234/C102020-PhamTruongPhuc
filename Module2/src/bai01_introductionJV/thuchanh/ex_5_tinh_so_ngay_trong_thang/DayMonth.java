package bai01_introductionJV.thuchanh.ex_5_tinh_so_ngay_trong_thang;

import java.util.Scanner;

public class DayMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Which month that you want to count days: ");
        int month = scanner.nextInt();

        String daysInMonth;

        switch (month) {
            case 2:
                daysInMonth = "29 or 30";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = "31";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = "30";
                break;
            default:
                daysInMonth = "";
                break;

        }

        if (daysInMonth != "") {
            System.out.printf("The month '%d' has %s days!",month,daysInMonth);
        } else {
            System.out.println("Invalid input");
        }
    }
}
