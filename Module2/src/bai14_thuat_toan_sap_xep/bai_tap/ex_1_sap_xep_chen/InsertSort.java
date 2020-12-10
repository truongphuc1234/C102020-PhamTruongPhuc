package bai14_thuat_toan_sap_xep.bai_tap.ex_1_sap_xep_chen;

public class InsertSort {
    static int[] list = {2, 5, 4, 3, 6, 7, 1, 9, 10, 15, 17, 20, 32, 12, 25};

    static void insertSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i; j < list.length - 1; j++) {
                if (list[j] < list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;


                }
            }
        }
    }
}
