package bai1_introductionJV.baitap.ex_1_hien_thi_loi_chao;

import java.util.Scanner;

public class PrintHello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello: "+ name);

    }
}
