import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LinkedList2Test {

    @Test
    void find() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));

        assertEquals(3, list.find(3).value);
        assertEquals(2, list.find(3).prev.value);
        assertEquals(1, list.head.value);
        assertEquals(4, list.tail.value);
    }

    @Test
    void find2() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));

        assertEquals(1, list.find(1).value);
        assertNull(list.find(1).prev);
        assertEquals(1, list.head.value);
        assertEquals(4, list.tail.value);
    }

    @Test
    void find3() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));

        assertEquals(4, list.find(4).value);
        assertEquals(3, list.find(4).prev.value);
        assertEquals(1, list.head.value);
        assertEquals(4, list.tail.value);
    }

    @Test
    void findAll() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(9));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(5));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(1));

        assertEquals(5, list.findAll(1).size());
    }


    @Test
    void removeFromEmptyList() {
        LinkedList2 list = new LinkedList2();
        assertFalse(list.remove(5));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeFromOneItemList() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        assertTrue(list.remove(1));
        assertNull(list.head);
        assertNull(list.tail);
    }

    @RepeatedTest(100)
    void removeFromLargeList() {
        LinkedList2 list = new LinkedList2();
        Random rnd = new Random();
        for (int i = 0; i < 1000; i++) {
            list.addInTail(new Node(rnd.nextInt(10)));
        }
        assertTrue(list.remove(1));
    }

    @Test
    void remove() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));

        assertTrue(list.remove(3));
        Node node = list.head;
        assertNull(node.prev);
        assertEquals(1, node.value);
        node = node.next;//2
        assertEquals(1, node.prev.value);
        assertEquals(2, node.value);
        node = node.next;//4
        assertEquals(2, node.prev.value);
        assertEquals(4, node.value);
        assertEquals(4, list.tail.value);
    }

    @Test
    void removeFirstItem() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));

        assertTrue(list.remove(1));
        Node node = list.head;
        assertNull(node.prev);
        assertEquals(2, node.value);
        node = node.next;
        assertEquals(2, node.prev.value);
        assertEquals(3, node.value);
        node = node.next;
        assertEquals(3, node.prev.value);
        assertEquals(4, node.value);
        assertEquals(4, list.tail.value);

    }

    @Test
    void removeLastItem() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));

        assertTrue(list.remove(4));
        Node node = list.head;
        assertNull(node.prev);
        assertEquals(1, node.value);
        node = node.next;//2
        assertEquals(1, node.prev.value);
        assertEquals(2, node.value);
        node = node.next;//4
        assertEquals(2, node.prev.value);
        assertEquals(3, node.value);
        assertNull(node.next);
        assertEquals(3, list.tail.value);
    }

    @Test
    void removeWrongItem() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));

        assertFalse(list.remove(5));
        Node node = list.head;
        assertNull(node.prev);
        assertEquals(1, node.value);
        node = node.next;//2
        assertEquals(1, node.prev.value);
        assertEquals(2, node.value);
        node = node.next;//4
        assertEquals(2, node.prev.value);
        assertEquals(3, node.value);
        assertNull(node.next);
        assertEquals(3, list.tail.value);
    }


    @Test
    void removeAll() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(3));
        for (int i = 0; i < 10; i++) {
            list.addInTail(new Node(1));
        }
        list.addInTail(new Node(2));
        list.addInTail(new Node(7));
        list.addInTail(new Node(7));
        list.addInTail(new Node(1));

        list.removeAll(1);

        Node node = list.head;
        assertNull(node.prev);
        assertEquals(3, node.value);
        node = node.next;
        assertEquals(3, node.prev.value);
        assertEquals(2, node.value);
        node = node.next;
        assertEquals(2, node.prev.value);
        assertEquals(7, node.value);
        node = node.next;
        assertEquals(7, node.prev.value);
        assertEquals(7, node.value);
        assertEquals(7, list.tail.value);
    }

    @Test
    void removeAllWrongItem() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));

        list.removeAll(5);
        Node node = list.head;
        assertNull(node.prev);
        assertEquals(1, node.value);
        node = node.next;//2
        assertEquals(1, node.prev.value);
        assertEquals(2, node.value);
        node = node.next;//4
        assertEquals(2, node.prev.value);
        assertEquals(3, node.value);
        assertNull(node.next);
        assertEquals(3, list.tail.value);
    }

    @Test
    void removeAllFromEmptyList() {
        LinkedList2 list = new LinkedList2();
        list.removeAll(1);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void removeAllFromOneItemList() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.removeAll(1);
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void clearEmptyList() {
        LinkedList2 list = new LinkedList2();
        list.clear();
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void clearOneItemList() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.clear();
        assertNull(list.head);
        assertNull(list.tail);
    }

    @Test
    void clearLargeList() {
        LinkedList2 list = new LinkedList2();
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
        LinkedList2 list = new LinkedList2();
        Random rnd = new Random();
        for (int i = 0; i < 10000; i++) {
            list.addInTail(new Node(rnd.nextInt(100)));
        }
        assertEquals(10000, list.count());
    }

    @Test
    void countEmptyList() {
        LinkedList2 list = new LinkedList2();
        assertEquals(0, list.count());
    }

    @Test
    void count() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        assertEquals(3, list.count());
    }

    @Test
    void insertAfterInEmptyList() {
        LinkedList2 list = new LinkedList2();
        list.insertAfter(null, new Node(5));
        assertEquals(5, list.head.value);
        assertNull(list.tail.prev);
        assertEquals(5, list.tail.value);
    }

    @Test
    void insertAfterOneItemList() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.insertAfter(list.find(1), new Node(555));
        Node node = list.head;
        assertNull(node.prev);
        assertEquals(1, node.value);
        node = node.next;
        assertEquals(555, node.value);
        assertEquals(1, node.prev.value);
        assertEquals(555, list.tail.value);
    }

    @Test
    void insertAfter() {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(5));
        list.insertAfter(list.find(1), new Node(555));
        Node node = list.head;
        assertNull(node.prev);
        assertEquals(1, node.value);
        node = node.next;
        assertEquals(1, node.prev.value);
        assertEquals(555, node.value);
        node = node.next;
        assertEquals(555, node.prev.value);
        assertEquals(1, node.value);
        node = node.next;
        assertEquals(1, node.prev.value);
        assertEquals(5, node.value);
        assertEquals(5, list.tail.value);
    }
}