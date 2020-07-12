public class StackLinkedList {

    private SinglyLinkedList linkedList;

    public StackLinkedList() {
        this.linkedList = new SinglyLinkedList();
    }

    public boolean push(int data) {
        linkedList.addFirst(data);
        return true;
    }

    public Object peek() {
        return linkedList.get(0);
    }

    public Object pop() {
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