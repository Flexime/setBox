package java_advanced1;

public class DoubleList<E> {
    private int size = 0;
    private Node head;
    private Node tail;

    public void push_back(E value) {
        if(tail == null) {
            tail = new Node(value, null, null);
            head = tail;
        }
        else {
            Node temp = new Node(value, null, tail);
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public void push_front(E value) {
        if(head == null) {
            head = new Node(value, null, null);
            tail = head;
        }
        else {
            Node temp = new Node(value, head, null);
            head.prev = temp;
            head = temp;
        }
        size++;
    }

    public void add(E value, int index) {

    }

    public void pop_back() {

    }

    public void pop_front() {

    }

    public void remove(int index) {

    }

    public int length() {return size;}

    public boolean contains(E value) {
        return false;
    }

    public E get(int index) {
        return null;
    }

    @Override
    public String toString(){
        String res = "[";
        Node cur = head;
        while(cur != null) {
            res = res + cur.value + ",";
            cur = cur.next;

        }
        return res.substring(0,res.length()-1)+"]";
    }

    private class Node<E>{
        private E value;
        private Node next;
        private Node prev;

        public Node(E value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}