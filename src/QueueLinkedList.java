public class QueueLinkedList {

    private CircularSinglyLinkedList linkedList;

    public QueueLinkedList() {
        linkedList = new CircularSinglyLinkedList();
    }

    public void enQueue(Object data) {
        linkedList.addLast(data);
    }

    public Object deQueue() {
        return linkedList.remove(0);
    }

    public void print() {
        linkedList.print();
    }

    public int size() {
        return linkedList.size();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public boolean isFull() {
        return linkedList.isFull();
    }

}