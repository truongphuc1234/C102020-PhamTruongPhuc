package bai11_dsa_stack_queue.bai_tap.ex_5_palidrome;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Stack<Character> reserve = new Stack<>();
        Queue<Character> same = new LinkedList<>();

        Scanner scanner= new Scanner(System.in);

        System.out.println("Enter a phrase: ");
        String phrase = scanner.nextLine();

        char[] phraseArray =  phrase.toCharArray();

        for(char element : phraseArray){
            reserve.push(element);
            same.add(element);
        }
        boolean isPalindrome = true;

        while(!reserve.isEmpty()){
            if(reserve.pop() != same.remove()){
                isPalindrome = false;
                break;
            }
        }
        if(isPalindrome){
            System.out.println("Is a palindrome.");
        } else{
            System.out.println("Is NOT a palindrome.");
        }

    }
}
