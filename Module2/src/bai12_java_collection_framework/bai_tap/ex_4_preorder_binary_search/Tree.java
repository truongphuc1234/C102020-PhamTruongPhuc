package bai12_java_collection_framework.bai_tap.ex_4_preorder_binary_search;

public interface Tree<E> {
    public boolean insert(E e);
    public void inorder();
    public int getSize();
}
