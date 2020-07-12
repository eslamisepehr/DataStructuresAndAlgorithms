public class IntList {

    private int[] elements;
    private int size;

    public IntList(int length) {
        elements = new int[length];
    }

    public void add(int element) {
        if (isFull())
            return;

        elements[size++] = element;
    }

    public void add(int index, int element) {
        if (!isIndexValid(index) || isFull())
            return;

        for (int i = size; i > index; i--)
            elements[i] = elements[i - 1];

        elements[index] = element;
        size++;
    }

    public int remove(int index) {
        if (!isIndexValid(index) || isEmpty())
            return -1;

        int element = elements[index];
        for (int i = index; i < size - 1; i++)
            elements[i] = elements[i + 1];

        size--;
        return element;
    }

    public int get(int index) {
        if (!isIndexValid(index))
            return -1;
        return elements[index];
    }

    public void set(int index, int element) {
        if (!isIndexValid(index))
            return;
        elements[index] = element;
    }

    public void print() {
        for (int i = 0; i < size; i++)
            System.out.println(elements[i]);
    }

    public void reversePrint() {
        if (isEmpty())
            return;

        for (int i = size - 1; i >= 0; i--)
            System.out.println(elements[i]);
    }

    public boolean isIndexValid(int index) {
        return index >= 0 && index <= size;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == elements.length;
    }
}