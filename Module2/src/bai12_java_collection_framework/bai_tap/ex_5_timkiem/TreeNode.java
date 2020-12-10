package bai12_java_collection_framework.bai_tap.ex_5_timkiem;

public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E e){
        element = e;
    }
}