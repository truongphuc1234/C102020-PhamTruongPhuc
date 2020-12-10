package bai13_thuat_toan_tim_kiem.bai_tap.ex_3_chuoi_xep_lon_nhat;

import java.util.Scanner;

public class FindMaxString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String inputString = scanner.nextLine();
        String orderInput = "";
        String maxOrderInput = "";
        char lastChar = (char) 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) > lastChar) {
                orderInput += inputString.charAt(i);
                if (maxOrderInput.length() < orderInput.length()) {
                    maxOrderInput = orderInput;
                }
            } else
                orderInput = "" + inputString.charAt(i);
            lastChar = inputString.charAt(i);
        }
        System.out.println(maxOrderInput);
    }
}
//Độ phức tạp của thuật toán là O(N)
