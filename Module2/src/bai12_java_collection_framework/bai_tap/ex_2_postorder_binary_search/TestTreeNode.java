package bai12_java_collection_framework.bai_tap.ex_2_postorder_binary_search;

public class TestTreeNode {
    public static void main(String[] args) {
        TreeNode<Integer> treeNode = new TreeNode<>();
        treeNode.insert(4);
        treeNode.insert(1);
        treeNode.insert(12);
        treeNode.insert(13);
        treeNode.insert(2);
        treeNode.insert(14);
        treeNode.insert(12);
        treeNode.insert(11);
        treeNode.insert(131);
        System.out.println(treeNode.postOrder());
    }
}
