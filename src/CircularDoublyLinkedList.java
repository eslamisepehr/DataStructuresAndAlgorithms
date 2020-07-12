public class CircularDoublyLinkedList {

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
            node.prev = node;
            node.next = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
            head.prev = tail;
            tail.next = head;
        }
        size++;
    }

    public void addLast(Object data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = node;
            tail = node;
            node.prev = node;
            node.next = node;
        } else {
            node.prev = tail;
            tail.next = node;
            node.next = head;
            tail = node;
            head.prev = tail;
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

        if (index == size) {
            tail = node;
            tail.next = head;
            head.prev = tail;
        }

        size++;
    }

    public Object removeFirst() {
        if (isEmpty())
            return null;
        Object data = head.data;
        head = head.next;
        head.prev = tail;
        tail.next = head;
        if (size == 1) {
            head = null;
            tail = null;
        }
        size--;
        return data;
    }

    public Object removeLast() {
        if (isEmpty())
            return null;
        Object data = tail.data;
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        if (size == 1) {
            head = null;
            tail = null;
        }
        size--;
        return data;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size || isEmpty())
            return null;

        if (index == 0) {
            Object data = head.data;
            head = head.next;
            head.prev = tail;
            tail.next = head;
            if (head == tail) {
                head = null;
                tail = null;
            }
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
            tail.next = head;
            head.prev = tail;
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

    public void print() {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public Object get(int index) {
        Node node = find(index);
        if (node == null)
            return null;
        return node.data;
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