public class SinglyLinkedList {

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
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void addLast(Object data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
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
            if (size == 1)
                tail = null;
            size--;
            return data;
        }

        Node prev = find(index - 1);
        Node current = prev.next;
        Node next = current.next;
        prev.next = next;

        if (index == size - 1) {
            tail = prev;
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
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    private void printRecursivly(Node node) {
        System.out.println(node.data);
        if (node.next != null)
            printRecursivly(node.next);
    }

    public void printRecursivly() {
        printRecursivly(head);
    }

    public SinglyLinkedList reverse() {
        SinglyLinkedList reverseList = new SinglyLinkedList();
        Node temp = head;
        while (temp != null) {
            reverseList.addFirst(temp.data);
            temp = temp.next;
        }
        return reverseList;
    }

    private Node reverseRecursively(Node node) {
        if ((node.next == null))
            return node;
        Node newHead = reverseRecursively(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    public void reverseRecursively() {
        head = reverseRecursively(head);
    }

    public CircularDoublyLinkedList convertToCircularDoublyLinkedList() {
        CircularDoublyLinkedList circularDoublyLinkedList = new CircularDoublyLinkedList();
        Node temp = head;
        while (temp != null) {
            circularDoublyLinkedList.addLast(temp.data);
            temp = temp.next;
        }
        return circularDoublyLinkedList;
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
        while (temp.next != null)
            temp = temp.next;
        return temp;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return false;
    }

}