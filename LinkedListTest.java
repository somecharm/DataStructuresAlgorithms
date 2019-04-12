import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

class LinkedListTest {

    @Test
    void findAllInEmptyList() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.findAll(1).size());
    }

    @Test
    void findAll() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        list.addInTail(new Node(3));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));

        assertEquals(5, list.findAll(1).size());
    }

    @Test
    void removeFromEmptyList() {
        LinkedList list = new LinkedList();
        assertFalse(list.remove(5));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeFromOneItemList() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        assertTrue(list.remove(1));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @RepeatedTest(100)
    void removeFromLargeList() {
        LinkedList list = new LinkedList();
        Random rnd = new Random();
        for (int i = 0; i < 1000; i++) {
            list.addInTail(new Node(rnd.nextInt(10)));
        }
        assertTrue(list.remove(1));
    }

    @Test
    void remove() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(3));
        list.addInTail(new Node(5));
        list.addInTail(new Node(1));
        list.addInTail(new Node(3));

        assertTrue(list.remove(1));
        Node node = list.head;
        assertEquals(3, node.value);
        node = node.next;
        assertEquals(5, node.value);
        node = node.next;
        assertEquals(3, node.value);
        assertEquals(3, list.tail.value);
    }

    @Test
    void removeFirstItem() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(3));
        for (int i = 0; i < 10; i++) {
            list.addInTail(new Node(1));
        }
        assertTrue(list.remove(3));
        assertEquals(1, list.head.value);
    }

    @Test
    void removeLastItem() {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.addInTail(new Node(1));
        }
        list.addInTail(new Node(3));
        list.addInTail(new Node(7));
        assertTrue(list.remove(7));
        assertEquals(3, list.tail.value);
    }

    @Test
    void removeAll() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        list.addInTail(new Node(3));
        for (int i = 0; i < 10; i++) {
            list.addInTail(new Node(1));
        }
        list.addInTail(new Node(2));
        list.addInTail(new Node(7));
        list.addInTail(new Node(1));

        list.removeAll(1);

        Node node = list.head;
        assertEquals(3, node.value);
        node = node.next;
        assertEquals(2, node.value);
        node = node.next;
        assertEquals(7, node.value);
        assertEquals(7, list.tail.value);

    }

    @Test
    void removeAllFromEmptyList() {
        LinkedList list = new LinkedList();
        list.removeAll(1);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeAllFromOneItemList() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        list.removeAll(1);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void clearEmptyList() {
        LinkedList list = new LinkedList();
        list.clear();
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void clearOneItemList() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        list.clear();
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void clearLargeList() {
        LinkedList list = new LinkedList();
        Random rnd = new Random();
        for (int i = 0; i < 1000; i++) {
            list.addInTail(new Node(rnd.nextInt(100)));
        }
        list.clear();
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void countLargeList() {
        LinkedList list = new LinkedList();
        Random rnd = new Random();
        for (int i = 0; i < 10000; i++) {
            list.addInTail(new Node(rnd.nextInt(100)));
        }
        assertEquals(10000, list.count());
    }

    @Test
    void countEmptyList() {
        LinkedList list = new LinkedList();
        assertEquals(0, list.count());
    }

    @Test
    void count() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        assertEquals(3, list.count());
    }

    @Test
    void insertAfterInEmptyList() {
        LinkedList list = new LinkedList();
        list.insertAfter(null, new Node(5));
        assertEquals(5, list.head.value);
        assertEquals(5, list.tail.value);
    }

    @Test
    void insertAfterOneItemList() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        list.insertAfter(list.find(1), new Node(555));
        Node node = list.head;
        assertEquals(1, node.value);
        node = node.next;
        assertEquals(555, node.value);
        assertEquals(555, list.tail.value);
    }

    @Test
    void insertAfter() {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(5));
        list.insertAfter(list.find(1), new Node(555));
        Node node = list.head;
        assertEquals(1, node.value);
        node = node.next;
        assertEquals(555, node.value);
        node = node.next;
        assertEquals(1, node.value);
        node = node.next;
        assertEquals(5, node.value);
        assertEquals(5, list.tail.value);
    }
}