package bai12_java_collection_framework.bai_tap.ex_3_delete_binary_search;

public class TestBTS {
    public static void main(String[] args) {
        BTS<Integer> tree = new BTS<>();
        tree.insert(30);
        tree.insert(6);
        tree.insert(8);
        tree.insert(42);
        tree.insert(50);
        tree.insert(32);
        tree.insert(2);
        tree.insert(34);
        tree.insert(31);
        tree.insert(33);

        System.out.println(tree.delete(32));
        tree.inorder();
    }
}
