package bai11_dsa_stack_queue.bai_tap.ex_3_dem_so_tu_su_dung_map_tree;

public class TreeNode {
    private char key;
    private int value;
    private TreeNode right;
    private TreeNode left;

    public TreeNode() {
    }

    public void insert(char key) {
        if (this.key == '\u0000') {
            this.key = key;
            value++;
            return;
        }
        if (this.key > key) {
            if(this.left == null){
                this.left =new TreeNode();
            }
            this.left.insert(key);
        } else if (this.key < key) {
            if(this.right ==null){
                this.right = new TreeNode();
            }
            this.right.insert(key);
        } else {
            this.value++;
        }

    }

    @Override
    public String toString() {
        String result = "";
        if(this.left !=null){
            result+= this.left.toString();
        }
        result+= " { "+this.key+" ; "+this.value+" } ";

        if(this.right !=null){
            result+= this.right.toString();
        }
        return result;
    }
}
