package bai12_java_collection_framework.thuc_hanh.ex_5_tim_kiem_nhi_phan;

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

        System.out.println("Inorder (sorted): ");
        tree.inorder();

        System.out.println("Number of nodes is: "+ tree.getSize());

    }
}
