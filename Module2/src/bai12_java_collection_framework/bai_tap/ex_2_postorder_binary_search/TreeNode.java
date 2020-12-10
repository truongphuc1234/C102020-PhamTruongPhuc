package bai12_java_collection_framework.bai_tap.ex_2_postorder_binary_search;

public class TreeNode<E extends Comparable<E>> {
    private E element;
    private TreeNode left;
    private TreeNode right;

    TreeNode(){}

    TreeNode(E element){
        this.element = element;
    }

    public void insert(E element){
        if(this.element == null){
            this.element = element;
            return;
        }
        if(this.element.compareTo(element) ==1){
            if (this.left == null){
                this.left = new TreeNode();
            }
            this.left.insert(element);
        } else if(this.element.compareTo(element) == -1){
            if(this.right == null){
                this.right = new TreeNode();
            }
            this.right.insert(element);
        }
    }

    public String postOrder(){
        String result ="";
        if(this.left != null){
            result+=this.left.postOrder();
        }
        if(this.right != null){
            result+= this.right.postOrder();
        }
        result+= "{"+element.toString()+"}";
        return result;
    }
}
