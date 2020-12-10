package bai13_thuat_toan_tim_kiem.bai_tap.ex_2_binary_search_de_qui;

public class RecursiveBinarySearch {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

    public static int recursiveSearch(int[] list, int key, int first, int last) {
        if (first > last) {
            return -1;
        }
        int num = (first + last) / 2;
        if (list[num] == key) {
            return num;
        } else if (list[num] > key) {
            return recursiveSearch(list, key, first, num);
        } else {
            return recursiveSearch(list, key, num, last);
        }
    }

    public static void main(String[] args) {
        System.out.println(recursiveSearch(list,7,0,list.length-1));
    }
}
