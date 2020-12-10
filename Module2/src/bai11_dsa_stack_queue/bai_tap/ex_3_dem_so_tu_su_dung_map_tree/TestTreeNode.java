package bai11_dsa_stack_queue.bai_tap.ex_3_dem_so_tu_su_dung_map_tree;

import java.util.Scanner;

public class TestTreeNode {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a phrase: ");
        String newString = scanner.nextLine();

        char[] charArray = newString.toLowerCase().toCharArray();

        for(char c : charArray){
            treeNode.insert(c);
        }

        System.out.println(treeNode.toString());
    }
}
