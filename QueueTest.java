import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void enqueue() {
        Queue<Integer> qu = new Queue<>();
        qu.enqueue(new Integer(0));
        assertEquals(0, qu.queue.getFirst());
        qu.enqueue(new Integer(1));
        assertEquals(1, qu.queue.get(1));
    }

    @Test
    void dequeue() {
        Queue<Integer> qu = new Queue<>();
        qu.enqueue(new Integer(0));
        qu.enqueue(new Integer(1));
        qu.dequeue();
        assertEquals(1, qu.queue.get(0));
        assertEquals(1, qu.queue.size());
    }

    @Test
    void dequeueEmpty() {
        Queue<Integer> qu = new Queue<>();
        qu.enqueue(new Integer(5));
        qu.dequeue();
        assertEquals(0, qu.queue.size());
    }

    @Test
    void rotate1() {
        Queue<Integer> qu = new Queue<>();
        qu.enqueue(new Integer(0));
        qu.enqueue(new Integer(1));
        qu.enqueue(new Integer(2));
        qu.enqueue(new Integer(3));
        qu.rotate(1);
        assertEquals(1, qu.queue.get(0));
        assertEquals(2, qu.queue.get(1));
        assertEquals(3, qu.queue.get(2));
        assertEquals(0, qu.queue.get(3));
    }

    @Test
    void rotate2() {
        Queue<Integer> qu = new Queue<>();
        qu.enqueue(new Integer(0));
        qu.enqueue(new Integer(1));
        qu.enqueue(new Integer(2));
        qu.enqueue(new Integer(3));
        qu.rotate(10);
        assertEquals(2, qu.queue.get(0));
        assertEquals(3, qu.queue.get(1));
        assertEquals(0, qu.queue.get(2));
        assertEquals(1, qu.queue.get(3));
    }

    @Test
    void rotate3() {
        Queue<Integer> qu = new Queue<>();
        qu.enqueue(new Integer(0));
        qu.enqueue(new Integer(1));
        qu.enqueue(new Integer(2));
        qu.enqueue(new Integer(3));
        qu.rotate(7);
        assertEquals(3, qu.queue.get(0));
        assertEquals(0, qu.queue.get(1));
        assertEquals(1, qu.queue.get(2));
        assertEquals(2, qu.queue.get(3));
    }

    @Test
    void rotate4() {
        Queue<Integer> qu = new Queue<>();
        qu.enqueue(new Integer(0));
        qu.enqueue(new Integer(1));
        qu.enqueue(new Integer(2));
        qu.enqueue(new Integer(3));
        qu.rotate(4);
        assertEquals(0, qu.queue.get(0));
        assertEquals(1, qu.queue.get(1));
        assertEquals(2, qu.queue.get(2));
        assertEquals(3, qu.queue.get(3));
    }
}