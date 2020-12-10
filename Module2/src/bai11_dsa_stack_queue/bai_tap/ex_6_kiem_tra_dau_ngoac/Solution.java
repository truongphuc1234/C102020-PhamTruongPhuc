package bai11_dsa_stack_queue.bai_tap.ex_6_kiem_tra_dau_ngoac;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an expression: ");
        String expression = scanner.nextLine();

        System.out.println(checkParenthesis(expression));
    }

    private static boolean checkParenthesis(String expression) {
        Stack<Integer> bStack = new Stack<>();
        char[] expressionArray = expression.toCharArray();
        for (char element : expressionArray) {
            if (element == '(') {
                bStack.push(0);
            } else if (element == ')') {
                if(bStack.isEmpty()){
                    return false;
                }
                if(bStack.pop() != 0){
                    return false;
                }
            }
        }
        if(bStack.isEmpty())
            return true;
        else
            return false;
    }
}
