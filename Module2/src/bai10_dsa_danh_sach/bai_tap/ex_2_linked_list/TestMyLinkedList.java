package bai10_dsa_danh_sach.bai_tap.ex_2_linked_list;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        myList.addFirst( 1);
        myList.add(1, 2);
        myList.addFirst(3);
        myList.add(3, 4);
        myList.addLast(7);
        display(myList);

        System.out.println(myList.indexOf(4));

        MyLinkedList<Integer> myNewList = myList.clone();
        display(myNewList);

        System.out.println(myNewList.getFirst());
        System.out.println(myNewList.getLast());

        myNewList.clear();

        display(myNewList);

    }

    public static void display(MyLinkedList<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + "\t");
        }
        System.out.println("\n" + array.size());
    }
}
