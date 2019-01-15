package circularQueue;

public class CircularQueue<E> {
    private static int INITIAL_CAPACITY = 16;
    private int size;
    E[] elements;
    int startIndex;
    int endIndex;

    public CircularQueue() {
        this.elements = (E[]) new Object[INITIAL_CAPACITY];
    }

    public CircularQueue(int initialCapacity) {
        this.elements = (E[]) new Object[initialCapacity];
    }

    public int size() {
        return this.size;
    }

    private  void setSize(int size) {
        this.size = size;
    }

    public void enqueue(E element) {
        if (this.size() >= elements.length){
            grow();
        }

        this.elements[this.endIndex] = element;
        this.endIndex = (this.endIndex + 1) % this.elements.length;
        this.setSize(this.size() + 1);
    }

    public E dequeue() {
        if(this.size == 0){
            throw new IllegalArgumentException();
        }

        E element = this.elements[startIndex];
        this.startIndex = (this.startIndex + 1) % this.elements.length;
        this.setSize(this.size() - 1);

        return element;
    }

    public E[] toArray() {
        E[] elementsArray = (E[]) new Object[this.size];

        int sourceIndex = this.startIndex;
        int destinationIndex = 0;

        for (int a = 0; a < this.size(); a++) {
            elementsArray[destinationIndex++] = this.elements[sourceIndex];
            sourceIndex = (sourceIndex + 1) % this.elements.length;
        }

        return elementsArray;
    }

    private void grow() {
        E[] newElementsArray = (E[]) new Object[this.size() * 2];

        int sourceIndex = this.startIndex;
        int destinationIndex = 0;

        for (int a = 0; a < this.size(); a++) {
            newElementsArray[destinationIndex++] = this.elements[sourceIndex];
            sourceIndex = (sourceIndex + 1) % this.elements.length;
        }

        this.elements = newElementsArray;
        this.startIndex = 0;
        this.endIndex = this.size();
    }
}