package bai12_java_collection_framework.thuc_hanh.ex_5_tim_kiem_nhi_phan;

public interface Tree<E> {
    public boolean insert(E e);
    public void inorder();
    public int getSize();
}
