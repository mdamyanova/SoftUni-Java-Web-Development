package circularQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CircularQueueTests {

    @Test
    public void enqueue_emptyQueue_shouldAddElement() {
        CircularQueue<Integer> queue = new CircularQueue<>();

        queue.enqueue(5);

        int expectedSize = 1;
        Assertions.assertEquals(expectedSize, queue.size());
    }

    @Test
    public void enqueueDeque_shouldWorkCorrectly() {
        CircularQueue<String> queue = new CircularQueue<>();
        String element = "some value";

        queue.enqueue(element);
        String elementFromQueue = queue.dequeue();

        int expectedSize = 0;
        Assertions.assertEquals(expectedSize, queue.size());
        Assertions.assertEquals(element, elementFromQueue);
    }

    @Test
    public void dequeue_emptyQueue_throwsException() {
        CircularQueue<Integer> queue = new CircularQueue<>();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            queue.dequeue();
        });
    }

    @Test
    public void enqueueDequeue100Elements_shouldWorkCorrectly() {
        CircularQueue<Integer> queue = new CircularQueue<>();
        int numberOfElements = 1000;

        for (int i = 0; i < numberOfElements; i++) {
            queue.enqueue(i);
        }

        for (int i = 0; i < numberOfElements; i++) {
            int expectedSize = numberOfElements - i;

            Assertions.assertEquals(expectedSize, queue.size());
            int element = queue.dequeue();
            Assertions.assertEquals(i, element);

            expectedSize = numberOfElements - i - 1;
            Assertions.assertEquals(expectedSize, queue.size());
        }
    }

    @Test
    public void circularQueue_enqueueDequeueManyChunks_shouldWorkCorrectly() {
        CircularQueue<Integer> queue = new CircularQueue<>();
        int chunks = 100;

        int value = 1;
        for (int i = 0; i < chunks; i++) {
            Assertions.assertEquals(0, queue.size());
            int chunkSize = i + 1;
            for (int counter = 0; counter < chunkSize; counter++) {
                Assertions.assertEquals(value - 1, queue.size());
                queue.enqueue(value);
                Assertions.assertEquals(value, queue.size());
                value++;
            }

            for (int counter = 0; counter < chunkSize; counter++) {
                value--;
                Assertions.assertEquals(value, queue.size());
                queue.dequeue();
                Assertions.assertEquals(value - 1, queue.size());
            }

            Assertions.assertEquals(0, queue.size());
        }
    }

    @Test
    public void enqueue500Elements_toArray_shouldWorkCorrectly() {
        Object[] array = new Object[500];
        for (int i = 0; i < 500; i++) {
            array[i] = i;
        }

        CircularQueue<Object> queue = new CircularQueue<>();

        for (int i = 0; i < array.length; i++) {
            queue.enqueue(array[i]);
        }

        Object[] arrayFromQueue = queue.toArray();

        Assertions.assertArrayEquals(array, arrayFromQueue);
    }

    @Test
    public void initialCapacity1_enqueueDequeue20Elements_shouldWorkCorrectly() {
        int elementsCount = 20;
        int initialCapacity = 1;

        CircularQueue<Integer> queue = new CircularQueue<>(initialCapacity);
        for (int i = 0; i < elementsCount; i++) {
            queue.enqueue(i);
        }

        Assertions.assertEquals(elementsCount, queue.size());
        for (int i = 0; i < elementsCount; i++) {
            int elementFromQueue = queue.dequeue();
            Assertions.assertEquals(i, elementFromQueue);
        }

        Assertions.assertEquals(0, queue.size());
    }
}