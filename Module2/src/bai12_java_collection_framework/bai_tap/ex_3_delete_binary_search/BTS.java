package bai12_java_collection_framework.bai_tap.ex_3_delete_binary_search;

public class BTS<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size;

    public BTS() {

    }

    public BTS(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            insert(objects[i]);
        }
    }

    @Override
    public boolean insert(E e) {
        if (root == null) {
            root = new TreeNode<>(e);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            }
            if (e.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<>(e);
            } else
                parent.right = new TreeNode<>(e);
        }
        size++;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        boolean isCurrentInLeft = false;
        while (current != null && current.element.compareTo(e) != 0) {
            if (current.element.compareTo(e) > 0) {
                parent = current;
                current = current.left;
                isCurrentInLeft = true;
            } else {
                parent = current;
                current = current.right;
                isCurrentInLeft = false;
            }
        }
        if (current == null) {
            return false;
        }
        TreeNode<E> holderLeft = current.left;
        TreeNode<E> holderRight = current.right;
        if (holderLeft == null) {
            if(isCurrentInLeft) {
                parent.left = holderRight;
            }else{
                parent.right = holderRight;
            }
            return true;
        }
        if(holderLeft.right == null){
            if(isCurrentInLeft) {
                parent.left = holderLeft;
            }else{
                parent.right = holderLeft;
            }
            return true;
        }
        TreeNode<E> mostRight = holderLeft;
        TreeNode<E> parentMostRight = null;

        while (mostRight.right != null) {
            parentMostRight = mostRight;
            mostRight = mostRight.right;
        }
        if (parentMostRight != null) {
            parentMostRight.right = mostRight.left;
        }
        if (parent == null) {
            root = mostRight;
            root.right = holderRight;
            root.left = holderLeft;
        } else {
            if (isCurrentInLeft) {
                parent.left = mostRight;
                parent.left.left = holderLeft;
                parent.left.right = holderRight;
            } else {
                parent.right = mostRight;
                parent.right.left = holderLeft;
                parent.right.right = holderRight;
            }
        }
        return true;
    }
}