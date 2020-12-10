package bai11_dsa_stack_queue.bai_tap.ex_4_chuyen_he_thap_phan;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int number;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number");
        number = scanner.nextInt();

        do{
            stack.push(number%2);
            number = number/2;
        } while(number != 0);

        String result = "";
        while (!stack.isEmpty()){
            result+= stack.pop();
        }

        System.out.println(result);
    }
}
