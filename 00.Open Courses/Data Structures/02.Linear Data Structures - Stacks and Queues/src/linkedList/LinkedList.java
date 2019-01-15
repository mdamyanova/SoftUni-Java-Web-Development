package linkedList;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    public class Node {
        private E value;
        private Node next;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return this.value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    private int size;
    private Node head;
    private Node tail;

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void addFirst(E item) {
        Node oldHead = this.head;
        this.head = new Node(item);
        this.head.setNext(oldHead);

        if (this.size() == 0) {
            this.tail = this.head;
        }

        this.setSize(this.size() + 1);
    }

    public void addLast(E item) {
        Node oldTail = this.tail;
        this.tail = new Node(item);

        if (this.size() == 0) {
            this.head = this.tail;
        } else {
            oldTail.setNext(this.tail);
        }

        this.setSize(this.size() + 1);
    }

    public E removeFirst() {
        if (this.size() == 0) {
            throw new UnsupportedOperationException();
        }

        Node oldHead = this.head;
        this.head = this.head.getNext();
        this.setSize(this.size() - 1);

        if (this.size() == 0) {
            this.tail = null;
        }

        return oldHead.getValue();
    }

    public E removeLast() {
        if (this.size() == 0) {
            throw new UnsupportedOperationException();
        }

        Node oldTail = this.tail;

        if (this.size() == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node newTail = this.getSecondToLastNode();
            newTail.setNext(null);
            this.tail = newTail;
        }

        this.setSize(this.size() - 1);
        return oldTail.getValue();
    }

    private Node getSecondToLastNode() {
        Node current = this.head;

        while (current.getNext() != this.tail) {
            current = current.getNext();
        }

        return current;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private final class ListIterator implements Iterator<E> {
        private Node current;

        private ListIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return this.current == tail;
        }

        @Override
        public E next() {
            E returnValue = this.current.getValue();
            this.current = this.current.getNext();
            return returnValue;
        }
    }
}