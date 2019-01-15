package linkedList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTests {

    @Test
    public void addFirstShouldIncreaseCount() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(1);

        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void addLastShouldIncreaseCount() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(1);

        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void addFirstShouldAddElement() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(1);

        for (Integer item : list) {
            Assertions.assertEquals(Integer.valueOf(1), item);
        }
    }

    @Test
    public void AddLastShouldAddElement() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addLast(1);

        for (Integer item : list) {
            Assertions.assertEquals(Integer.valueOf(1), item);
        }
    }

    @Test
    public void addFirstMultipleElementsShouldAddElement() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addFirst(i);
        }

        int expected = 99;
        for (Integer item : list) {
            Assertions.assertEquals(expected--, list.size());
        }
    }

    @Test
    public void addLastMultipleElementsShouldAddElement() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }

        int expected = 0;
        for (Integer item : list) {
            Assertions.assertEquals(expected++, list.size());
        }
    }

    @Test
    public void removeFirstSingleElementShouldDecreaseCount() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.removeFirst();

        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void RemoveLastSingleElementShouldDecreaseCount() {
        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.removeLast();

        Assertions.assertEquals(1, list.size());
    }

    @Test
    public void RemoveFirstMultipleElementsShouldRemove() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addLast(i);
        }

        for (Integer i = 0; i < 100; i++) {
            Assertions.assertEquals(i, list.removeFirst());
        }

        Assertions.assertEquals(0, list.size());
    }

    @Test
    public void RemoveLastMultipleElementsShouldRemove() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            list.addFirst(i);
        }

        for (Integer i = 0; i < 100; i++) {
            Assertions.assertEquals(i, list.removeLast());
        }

        Assertions.assertEquals(0, list.size());
    }
}