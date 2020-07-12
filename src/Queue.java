public class Queue {

    private int[] elements;
    private int front;
    private int rear;

    public Queue(int length) {
        elements = new int[length];
        front = 0;
        rear = 0;
    }

    public void enQueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        elements[rear++] = element;
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        int element = elements[front];
        for (int i = 0; i < rear - 1; i++)
            elements[i] = elements[i + 1];
        rear--;
        return element;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        for (int i = front; i < rear; i++)
            System.out.println(elements[i]);
    }

    public int size() {
        return rear;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == elements.length;
    }

}
