import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {

    @Test
    void makeArray() {
        DynArray ar = new DynArray<Integer>(Integer.class);

    }

    @Test
    void getItemException() {
        DynArray ar = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 20; i++) {
            ar.append(new Integer(i));
            assertEquals(i, ar.getItem(i));
            assertEquals(i + 1, ar.count);
        }

        try {
            ar.getItem(-1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
        try {
            ar.getItem(32);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    @Test
    void append() {
        DynArray ar = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++) {
            ar.append(new Integer(i));
            assertEquals(i, ar.getItem(i));
            assertEquals(i + 1, ar.count);
        }
        assertEquals(16, ar.count);
        assertEquals(16, ar.capacity);
    }

    @Test
    void appendMore() {
        DynArray ar = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 65; i++) {
            ar.append(new Integer(i));
            assertEquals(i, ar.getItem(i));
            assertEquals(i + 1, ar.count);
        }
        assertEquals(65, ar.count);
        assertEquals(128, ar.capacity);
    }

    @Test
    void insert() {
        DynArray ar = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 3; i++) {
            ar.append(new Integer(i));
        }
        ar.insert(new Integer(222), 2);
        assertEquals(0, ar.getItem(0));
        assertEquals(1, ar.getItem(1));
        assertEquals(222, ar.getItem(2));
        assertEquals(2, ar.getItem(3));

        assertEquals(4, ar.count);
        assertEquals(16, ar.capacity);
    }

    @Test
    void insertLast() {
        DynArray ar = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 3; i++) {
            ar.append(new Integer(i));
        }
        ar.insert(new Integer(222), 3);
        for (int i = 0; i < 4; i++) {
            System.out.println(ar.getItem(i));
        }
        assertEquals(0, ar.getItem(0));
        assertEquals(1, ar.getItem(1));
        assertEquals(2, ar.getItem(2));
        assertEquals(222, ar.getItem(3));

        assertEquals(4, ar.count);
        assertEquals(16, ar.capacity);
    }

    @Test
    void insertMore() {
        DynArray ar = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++) {
            ar.append(new Integer(i));
            assertEquals(i, ar.getItem(i));
            assertEquals(i + 1, ar.count);
        }
        ar.insert(new Integer(222), 3);
        assertEquals(17, ar.count);
        assertEquals(32, ar.capacity);
    }


    @Test
    void insertWrongIndex() {
        DynArray ar = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 3; i++) {
            ar.append(new Integer(i));
        }
        try {
            ar.insert(new Integer(222), 4);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        try {
            ar.insert(new Integer(222), -1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }


    }

    @Test
    void remove() {
        DynArray ar = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 3; i++) {
            ar.append(new Integer(i));
        }
        ar.remove(0);
        for (int i = 0; i < 3; i++) {
            System.out.println(ar.getItem(i));
        }
        assertEquals(1, ar.getItem(0));
        assertEquals(2, ar.getItem(1));

        assertEquals(2, ar.count);
        assertEquals(16, ar.capacity);
    }

    @Test
    void removeHalf() {
        DynArray ar = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 60; i++) {
            ar.append(new Integer(i));
        }
        for (int i = 0; i < 29; i++) {
            ar.remove(ar.count - 1);
        }
        for (int i = 0; i < ar.count; i++) {
            System.out.println(ar.getItem(i));
        }
        System.out.println("**********");
        System.out.println(ar.count);
        System.out.println(ar.capacity);

        assertEquals(31, ar.count);
        assertEquals(42, ar.capacity);
    }

    @Test
    void removeWrongIndex() {
        DynArray ar = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 10; i++) {
            ar.append(new Integer(i));
        }
        try {

            ar.remove(11);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
        }
        assertEquals(10, ar.count);
        assertEquals(16, ar.capacity);
    }
}