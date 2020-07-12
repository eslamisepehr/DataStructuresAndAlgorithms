public class StackIntList {

    private IntList intList;

    public StackIntList() {
        this.intList = new IntList(100);
    }

    public StackIntList(int length) {
        this.intList = new IntList(length);
    }

    public boolean push(int data) {
        if (isFull()) {
            System.out.println("Stack is full!");
            return false;
        }

        intList.add(data);
        return true;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return intList.get(size() - 1);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }

        return intList.remove(size() - 1);
    }

    public void print() {
        intList.reversePrint();
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