public class CircularSinglyLinkedList {

    class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(Object data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = node;
            node.next = head;
            tail = node;
        } else {
            node.next = head;
            head = node;
            tail.next = node;
        }
        size++;
    }

    public void addLast(Object data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = node;
            node.next = head;
            tail = node;
        } else {
            tail.next = node;
            node.next = head;
            tail = node;
        }
        size++;
    }

    public void add(int index, Object data) {
        if (index < 0 || index > size)
            return;

        Node node = new Node(data);

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node prev = find(index - 1);
        Node current = prev.next;
        node.next = current;
        prev.next = node;

        if (index == size) {
            tail = node;
            node.next = head;
        }

        size++;
    }

    public Object removeFirst() {
        return remove(0);
    }

    public Object removeLast() {
        return remove(size - 1);
    }

    public Object remove(int index) {
        if (index < 0 || index >= size || isEmpty())
            return null;

        if (index == 0) {
            Object data = head.data;
            head = head.next;
            tail.next = head;
            if (size == 1) {
                tail = null;
                head = null;
            }
            size--;
            return data;
        }

        Node prev = find(index - 1);
        Node current = prev.next;
        Node next = current.next;
        prev.next = next;

        if (index == size - 1) {
            tail = prev;
            tail.next = head;
        }

        size--;
        return current.data;
    }

    public void set(int index, Object data) {
        Node node = find(index);
        if (node == null)
            return;
        node.data = data;
    }

    public Object get(int index) {
        Node node = find(index);
        if (node == null)
            return null;
        return node.data;
    }

    public void print() {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public CircularSinglyLinkedList copy() {
        CircularSinglyLinkedList copyList = new CircularSinglyLinkedList();
        Node temp = head;
        for (int i = 0; i < size; i++) {
            copyList.addLast(temp.data);
            temp = temp.next;
        }
        return copyList;
    }

    private Node find(int index) {
        if (index < 0 || index >= size || isEmpty())
            return null;

        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;
        return temp;
    }

    private Node findTail() {
        if (isEmpty())
            return null;

        Node temp = head;
        while (temp.next != head)
            temp = temp.next;
        return temp;
    }

    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return false;
    }

}