package bai10_dsa_danh_sach.bai_tap.ex_1_array_list;

public class TestMyList {
    public static void main(String[] args) {
        MyList<Integer> arrays = new MyList<>();
        arrays.add(1);
        arrays.add(2);
        arrays.add(3);
        arrays.add(5);
        arrays.add(6);
        arrays.add(7);

        displayArray(arrays);

        arrays.add(0,10);
        arrays.add(7);
        arrays.add(11);
        arrays.add(21);
        arrays.add(722);
        arrays.add(72);
        arrays.add(27);
        arrays.add(7222);

        displayArray(arrays);

        arrays.remove(4);
        displayArray(arrays);

        System.out.println(arrays.indexOf(7));
        System.out.println(arrays.indexOf(8));
        System.out.println(arrays.contains(8));
        System.out.println(arrays.contains(7));

        arrays.clear();
        displayArray(arrays);

    }

    private static void displayArray(MyList<Integer> arrays) {
        for (int i = 0; i < arrays.size(); i++) {
            System.out.print(arrays.get(i) + "\t");
        }
        System.out.println();
    }
}
