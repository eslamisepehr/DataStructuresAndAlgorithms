public class Stack {

    private int[] elements;
    private int top;

    public Stack() {
        initialize(100);
    }

    public Stack(int length) {
        initialize(length);
    }

    private void initialize(int length) {
        elements = new int[length];
        top = -1;
    }

    public boolean push(int element) {
        if (isFull()) {
            System.out.println("Stack is full!");
            return false;
        }

        elements[++top] = element;
        return true;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }

        return elements[top];
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }

        return elements[top--];
    }

    public void print() {
        for (int i = top; i >= 0; i--)
            System.out.println(elements[i]);
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return size() == elements.length;
    }

}