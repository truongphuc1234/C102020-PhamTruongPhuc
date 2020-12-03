package bai01_introductionJV.baitap.ex_3_chuyen_doi_tien_te;

import java.util.Scanner;

public class CurrencyConvert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập tỉ giá giữa USD và VND: ");
        double rate = scanner.nextDouble();

        System.out.println("Nhập số USD: ");
        double numberUSD = scanner.nextDouble();

        double numberVND = rate * numberUSD;

        System.out.println("Số tiền VND quy đổi là: " + numberVND);
    }
}
