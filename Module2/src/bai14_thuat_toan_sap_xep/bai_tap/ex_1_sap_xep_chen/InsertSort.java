package bai14_thuat_toan_sap_xep.bai_tap.ex_1_sap_xep_chen;

public class InsertSort {
    static int[] list = {2, 5, 4, 3, 6, 7, 1, 9, 10, 15, 17, 20, 32, 12, 25};

    static void insertSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i -1;
            while(j >= 0 && list[j]> key ){
                list[j+1] = list[j];
                j--;
            }
            list[j+1] = key;
            display(list);
        }
    }


    public static void main(String[] args) {
        insertSort(list);
        display(list);
    }

    private static void display(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
    }
}
