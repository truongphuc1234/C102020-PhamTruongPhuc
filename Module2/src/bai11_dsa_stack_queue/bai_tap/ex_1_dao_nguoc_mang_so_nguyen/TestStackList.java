package bai11_dsa_stack_queue.bai_tap.ex_1_dao_nguoc_mang_so_nguyen;

import java.util.Arrays;
import java.util.Scanner;

public class TestStackList {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(reverseNumber(array)));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your phrase:");
        String input = scanner.nextLine();

        String[] inputArray = input.split(" ");
        System.out.println(String.join(" ",reverseString(inputArray)));
    }

    private static int[] reverseNumber(int[] array){
        StackList<Integer> stack = new StackList<>();
        for(int element : array){
            stack.push(element);
        }
        for(int i = 0; i < array.length; i++){
            array[i] = stack.pop();
        }
        return array;
    }

    private static String[] reverseString(String[] array){
        StackList<String> stack = new StackList<>();
        for(String element : array){
            stack.push(element);
        }
        for(int i = 0; i < array.length; i++){
            array[i] = stack.pop();
        }
        return array;
    }
}
