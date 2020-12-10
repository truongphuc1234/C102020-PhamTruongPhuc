package bai12_java_collection_framework.bai_tap.ex_5_timkiem;

public interface Tree<E> {
    public boolean insert(E e);
    public void inorder();
    public int getSize();
}
