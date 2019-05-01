import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderedListTest {

    @Test
    void compare() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(-1);
        assertEquals(-1, ol.head.value);
        assertEquals(0, ol.tail.value);
        assertEquals(2, ol.count());
        for (Node node : ol.getAll()) {
            System.out.println(node.value);
        }
    }

    @Test
    void addAsc() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(10);
        ol.add(111);
        ol.add(3);
        ol.add(2);
        ol.add(-5);
        assertEquals(-5, ol.head.value);
        assertEquals(111, ol.tail.value);
        assertEquals(6, ol.count());
        for (Node node : ol.getAll()) {
            System.out.println(node.value);
        }

    }

    @Test
    void addDesc() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(10);
        ol.add(111);
        ol.add(3);
        ol.add(2);
        ol.add(-15);
        ol.add(2);
        assertEquals(111, ol.head.value);
        assertEquals(-15, ol.tail.value);
        assertEquals(7, ol.count());
        for (Node node : ol.getAll()) {
            System.out.println(node.value);
        }

    }

    @Test
    void findAsc() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(10);
        ol.add(5);
        ol.add(2);
        assertNull(ol.find(7));
        assertEquals(10, ol.find(10).value);
    }

    @Test
    void findDesc() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(10);
        ol.add(5);
        ol.add(2);
        assertNull(ol.find(7));
        assertEquals(10, ol.find(10).value);
    }

    @Test
    void findString() {
        OrderedList<String> ol = new OrderedList<>(true);
        ol.add("sdf");
        ol.add("fff");
        ol.add("zfgsfe");
        ol.add("argaaa");
        assertNull(ol.find("bgt"));
        assertEquals("fff", ol.find("fff").value);
    }

    @Test
    void find() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(10);
        ol.add(-1);
        assertEquals(10, ol.find(10).value);
        assertNull(ol.find(2));
    }

    @Test
    void findEmpty() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        assertNull(ol.find(2));
    }

    @Test
    void delete() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(10);
        ol.add(-1);
        ol.add(-2);
        ol.add(-2);
        ol.add(-5);

        ol.delete(10);
        assertEquals(5, ol.count());
        for (Node node : ol.getAll()) {
            System.out.println(node.value);
        }
    }

    @Test
    void deleteString() {
        OrderedList<String> ol = new OrderedList<>(true);
        ol.add("sdf");
        ol.add("fff");
        ol.add("zfgsfe");
        ol.add("argaaa");

        ol.delete("fff");
        assertEquals(3, ol.count());
        for (Node node : ol.getAll()) {
            System.out.println(node.value);
        }
    }

    @Test
    void deleteEmpty() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.delete(10);
        assertEquals(0, ol.count());

    }

    @Test
    void add() {
        OrderedList<String> ol = new OrderedList<>(false);
        ol.add("abc");
        ol.add(" bbc ");
        ol.add("aac");
        ol.add("zzz");
        ol.add("qwerty");
        for (Node node : ol.getAll()) {
            System.out.println(node.value);
        }
    }
}