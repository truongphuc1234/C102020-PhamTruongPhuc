package bai3_mang_jv.thuc_hanh.ex_5_tim_gia_tri_nho_nhat;

public class FindMin {

    public static int minValue(int[] array) {
        int max = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in array is " + arr[index]);
    }
}

