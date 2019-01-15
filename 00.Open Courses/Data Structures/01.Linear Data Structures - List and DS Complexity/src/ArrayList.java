import java.util.Arrays;

public class ArrayList<T> {
    private int count;
    private int capacity;
    private T[] elements;

    public ArrayList(int capacity){
        this.count = 0;
        this.capacity = capacity;
        this.elements = (T[])new Object[capacity];
    }

    public ArrayList(){
        this(4);
    }

    public int getCount() {
        return this.count;
    }

    public T get(int index) {
        if (index < 0 || index >= this.count){
            throw new IllegalArgumentException();
        }

        return this.elements[index];
    }

    public void set(int i, T item) {
        if (i < 0 || i >= this.count) {
            throw new IllegalArgumentException();
        }

        this.elements[i] = item;
    }

    public void add(T element) {
        if (this.count >= this.capacity){
            this.grow();
        }

        this.elements[this.count] = element;
        this.count++;
    }

    public T removeAt(int index) {
        T item = this.get(index);
        shiftLeft(index);

        if (this.count - 1 < this.capacity / 3){
            this.shrink();
        }

        this.count--;
        return item;
    }

    private void shiftLeft(int index) {
        for (int i = index; i < this.count - 1 ; i++) {
            this.elements[i] = this.elements[i+1];
        }

        this.elements[this.count - 1] = null;
    }

    private void shrink() {
        this.capacity /= 2;
        this.elements = Arrays.copyOf(this.elements, this.capacity);
    }

    private void grow() {
        this.capacity *= 2;
        this.elements = Arrays.copyOf(this.elements, this.capacity);
    }
}