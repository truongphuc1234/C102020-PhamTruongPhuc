package bai11_dsa_stack_queue.bai_tap.ex_2_queue_danh_sach_vong;

public class Node {
    private Object data;
    private Node link;

    public Object getData() {
        return data;
    }

    public Node getLink() {
        return link;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    Node(){}

    Node(Object data){
        this.data = data;
    }
}
