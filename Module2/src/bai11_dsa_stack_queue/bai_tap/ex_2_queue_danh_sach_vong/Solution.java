package bai11_dsa_stack_queue.bai_tap.ex_2_queue_danh_sach_vong;

public class Solution {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(1);
        System.out.println(queue.displayQueue());
        queue.enQueue(2);
        System.out.println(queue.displayQueue());
        queue.enQueue(3);
        System.out.println(queue.displayQueue());
        queue.enQueue(4);
        System.out.println(queue.displayQueue());
        queue.enQueue(5);
        System.out.println(queue.displayQueue());

        System.out.println(queue.deQueue());
        System.out.println(queue.displayQueue());

        System.out.println(queue.deQueue());
        System.out.println(queue.displayQueue());

        System.out.println(queue.deQueue());
        System.out.println(queue.displayQueue());

        System.out.println(queue.deQueue());
        System.out.println(queue.displayQueue());

    }
}
