public class DoublyLinkedList {

    class Node {
        private Object data;
        private Node prev;
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
            head.prev = node;
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
            node.prev = tail;
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
        prev.next = node;
        node.prev = prev;
        node.next = current;
        if (current != null)
            current.prev = node;

        if (index == size)
            tail = node;

        size++;
    }

    public Object removeFirst() {
        if (isEmpty())
            return null;
        Object data = head.next;
        head = head.next;
        if (head != null)
            head.prev = null;
        else
            tail = null;
        size--;
        return data;
    }

    public Object removeLast() {
        if (isEmpty())
            return null;
        Object data = tail.data;
        tail = tail.prev;
        if (tail != null)
            tail.next = null;
        else
            head = null;
        size--;
        return data;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size || isEmpty())
            return null;

        if (index == 0) {
            Object data = head.data;
            head = head.next;
            if (size == 1)
                tail = null;
            else
                head.prev = null;

            size--;
            return data;
        }

        Node current = find(index);
        Node prev = current.prev;
        Node next = current.next;
        prev.next = next;
        if (next != null)
            next.prev = prev;

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

    public SinglyLinkedList convertToSinglyLinkedList() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        Node temp = head;
        while (temp != null) {
            linkedList.addLast(temp.data);
            temp = temp.next;
        }
        return linkedList;
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