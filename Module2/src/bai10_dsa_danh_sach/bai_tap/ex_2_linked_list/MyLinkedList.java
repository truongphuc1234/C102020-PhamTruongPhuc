package bai10_dsa_danh_sach.bai_tap.ex_2_linked_list;

public class MyLinkedList<E> {
    private static class Node<E> {
        private Node next;
        private E data;

        public Node() {
        }

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }
    }

    private Node head;
    private int numNodes;

    public MyLinkedList() {
    }

    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("index: " + index + ", size: " + numNodes);
        }

        if (head == null) {
            head = new Node(element);
            numNodes++;
            return;
        }

        Node temp = head;
        Node holder;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public E get(int i) {
        if (i < 0 || i >= numNodes) {
            throw new IndexOutOfBoundsException("index: " + i + ", size: " + numNodes);
        }
        Node temp = head;
        for (int j = 0; j < i; j++) {
            temp = temp.next;
        }

        return (E) temp.getData();
    }

    public int size() {
        return numNodes;
    }

    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        if (head == null) {
            head = new Node(element);
            numNodes++;
            return;
        }
        Node temp = head;

        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("index:" + index + ", size: " + numNodes);
        }

        if (index == 0) {
            E removed;
            removed = (E) head.getData();
            head = head.next;
            numNodes--;
            return removed;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node removed = temp.next;
            temp.next = temp.next.next;
            numNodes--;
            return (E) removed.getData();
        }
    }

    public MyLinkedList<E> clone() {
        MyLinkedList<E> newList = new MyLinkedList<>();
        for (int i = 0; i < numNodes; i++) {
            newList.addLast(this.get(i));
        }
        return newList;
    }

    public boolean contain(E e) {
        Node temp = head;
        while (temp != null) {
            if (temp.getData().equals(e)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E e) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(e)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public E getFirst() {
        return (E) head.getData();
    }

    public E getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }

}
