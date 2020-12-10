package bai13_thuat_toan_tim_kiem.bai_tap.ex_1_tim_chuoi_voi_do_dai_tang_dan;

import java.util.Scanner;

public class FindMaxString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();
        String orderInput = "";
        char lastChar = (char) 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) >= lastChar) {
                orderInput += inputString.charAt(i);
            }
            lastChar=inputString.charAt(i);
        }
        System.out.println(orderInput);
    }
}
//Độ phức tạp của thuật toán là O(N)
