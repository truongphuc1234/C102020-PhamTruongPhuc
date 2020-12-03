package bai01_introductionJV.baitap.ex_2_chuyen_doi_so_thanh_chu;

import java.util.Scanner;

public class NumberConvert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = scanner.nextInt();
        String description = null;
        String hundredDesc = null;
        int hundred = 0;

        if (num >= 100) {
            hundred = (num - num % 100) / 100;
            num = num % 100;

            switch (hundred) {
                case 1:
                    hundredDesc = "one";
                    break;
                case 2:
                    hundredDesc = "two";
                    break;
                case 3:
                    hundredDesc = "three";
                    break;
                case 4:
                    hundredDesc = "four";
                    break;
                case 5:
                    hundredDesc = "five";
                    break;
                case 6:
                    hundredDesc = "six";
                    break;
                case 7:
                    hundredDesc = "seven";
                    break;
                case 8:
                    hundredDesc = "eight";
                    break;
                case 9:
                    hundredDesc = "nine";
                    break;
                default:
                    break;
            }
        }

        if (num <= 10) {
            switch (num) {
                case 0:
                    description = "zero";
                    break;
                case 1:
                    description = "one";
                    break;
                case 2:
                    description = "two";
                    break;
                case 3:
                    description = "three";
                    break;
                case 4:
                    description = "four";
                    break;
                case 5:
                    description = "five";
                    break;
                case 6:
                    description = "six";
                    break;
                case 7:
                    description = "seven";
                    break;
                case 8:
                    description = "eight";
                    break;
                case 9:
                    description = "night";
                    break;
                case 10:
                    description = "ten";
                    break;
            }
        } else if (num < 20) {
            switch (num) {
                case 11:
                    description = "eleven";
                    break;
                case 12:
                    description = "twelve";
                    break;
                case 13:
                    description = "thirteen";
                    break;
                case 14:
                    description = "forteen";
                    break;
                case 15:
                    description = "fifteen";
                    break;
                case 16:
                    description = "sixteen";
                    break;
                case 17:
                    description = "seventeen";
                    break;
                case 18:
                    description = "eighteen";
                    break;
                case 19:
                    description = "nineteen";
                    break;
            }
        } else if (num <= 99) {

            int unit = num % 10;
            int dividedTen = (num - unit) / 10;
            String divideTenDesc = null;
            String unitDesc = null;

            switch (dividedTen) {
                case 2:
                    divideTenDesc = "twenty";
                    break;
                case 3:
                    divideTenDesc = "thirty";
                    break;
                case 4:
                    divideTenDesc = "forty";
                    break;
                case 5:
                    divideTenDesc = "fifty";
                    break;
                case 6:
                    divideTenDesc = "sixty";
                    break;
                case 7:
                    divideTenDesc = "seventy";
                    break;
                case 8:
                    divideTenDesc = "eighty";
                    break;
                case 9:
                    divideTenDesc = "ninety";
                    break;
            }

            switch (unit) {
                case 0:
                    unitDesc = "";
                    break;
                case 1:
                    unitDesc = "one";
                    break;
                case 2:
                    unitDesc = "two";
                    break;
                case 3:
                    unitDesc = "three";
                    break;
                case 4:
                    unitDesc = "four";
                    break;
                case 5:
                    unitDesc = "five";
                    break;
                case 6:
                    unitDesc = "six";
                    break;
                case 7:
                    unitDesc = "seven";
                    break;
                case 8:
                    unitDesc = "eight";
                    break;
                case 9:
                    unitDesc = "night";
                    break;
                default:
                    break;
            }

            description = divideTenDesc + " " + unitDesc;
        }
        if (hundred > 0) {
            if (num == 0) {
                System.out.println(hundredDesc + " hundred");
            } else {
                System.out.printf("%s hundred and %s", hundredDesc, description);
            }
        } else {
            System.out.printf(description);
        }
    }
}


