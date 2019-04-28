import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    void addFront() {
        Deque<Integer> deq = new Deque<>();
        deq.addFront(new Integer(0));
        deq.addFront(new Integer(1));
        deq.addFront(new Integer(2));
        assertEquals(2, deq.deque.get(0));
        assertEquals(1, deq.deque.get(1));
        assertEquals(0, deq.deque.get(2));
        assertEquals(3, deq.size());
    }

    @Test
    void addTail() {
        Deque<Integer> deq = new Deque<>();
        deq.addTail(new Integer(0));
        deq.addTail(new Integer(1));
        deq.addTail(new Integer(2));
        assertEquals(0, deq.deque.get(0));
        assertEquals(1, deq.deque.get(1));
        assertEquals(2, deq.deque.get(2));
        assertEquals(3, deq.size());
    }

    @Test
    void removeFront() {
        Deque<Integer> deq = new Deque<>();
        deq.addFront(new Integer(0));
        deq.addFront(new Integer(1));
        deq.addFront(new Integer(2));
        deq.removeFront();
        assertEquals(1, deq.deque.get(0));
        assertEquals(0, deq.deque.get(1));
        assertEquals(2, deq.size());
        deq.removeFront();
        assertEquals(0, deq.deque.get(0));
        assertEquals(1, deq.size());
    }

    @Test
    void removeTail() {
        Deque<Integer> deq = new Deque<>();
        deq.addFront(new Integer(0));
        deq.addFront(new Integer(1));
        deq.addFront(new Integer(2));
        deq.removeTail();
        assertEquals(2, deq.deque.get(0));
        assertEquals(1, deq.deque.get(1));
        deq.removeTail();
        assertEquals(2, deq.deque.get(0));
    }

    @Test
    void size() {
        Deque<Integer> deq = new Deque<>();
        deq.addFront(new Integer(0));
        deq.removeTail();
        assertEquals(0, deq.size());
    }

    @Test
    void palindromo1() {
        Deque<String> deq = new Deque<>();
        assertTrue(deq.palindromo("комок"));
    }

    @Test
    void palindromo2() {
        Deque<String> deq = new Deque<>();
        assertTrue(deq.palindromo("анна"));
    }

    @Test
    void palindromo3() {
        Deque<String> deq = new Deque<>();
        assertTrue(deq.palindromo("кок"));
    }

    @Test
    void palindromo4() {
        Deque<String> deq = new Deque<>();
        assertFalse(deq.palindromo("ком"));
    }

    @Test
    void palindromo5() {
        Deque<String> deq = new Deque<>();
    }

    @Test
    void palindromo() {
        Deque<String> deq = new Deque<>();
        assertFalse(deq.palindromo("java"));
    }
}