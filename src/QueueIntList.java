public class QueueIntList {

    private IntList intList;

    public QueueIntList(int length) {
        intList = new IntList(length);
    }

    public void enQueue(int data) {
        if (intList.isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        intList.add(data);
    }

    public int deQueue() {
        if (intList.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        return intList.remove(0);
    }

    public void print() {
        intList.print();
    }

    public int size() {
        return intList.size();
    }

    public boolean isEmpty() {
        return intList.isEmpty();
    }

    public boolean isFull() {
        return intList.isFull();
    }

}