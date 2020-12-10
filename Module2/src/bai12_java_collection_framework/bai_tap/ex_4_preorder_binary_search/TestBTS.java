package bai12_java_collection_framework.bai_tap.ex_4_preorder_binary_search;

public class TestBTS {
    public static void main(String[] args) {
        BTS<String> tree = new BTS<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");

        tree.preorder();
        System.out.println();
        tree.inorder();

        System.out.println("Number of nodes is: "+ tree.getSize());
    }
}
