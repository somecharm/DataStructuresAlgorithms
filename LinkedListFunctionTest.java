import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListFunctionTest {

    @Test
    void sumLists() {
        LinkedList list1 = new LinkedList();
        list1.addInTail(new Node(1));
        list1.addInTail(new Node(80));
        list1.addInTail(new Node(0));
        list1.addInTail(new Node(2000));
        list1.addInTail(new Node(5));

        LinkedList list2 = new LinkedList();
        list2.addInTail(new Node(1));
        list2.addInTail(new Node(2));
        list2.addInTail(new Node(2));
        list2.addInTail(new Node(1));
        list2.addInTail(new Node(10));

        LinkedList sum_list = LinkedListFunction.sum(list1, list2);
        try {
            Node node = sum_list.head;
            assertEquals(2, node.value);
            node = node.next;
            assertEquals(82, node.value);
            node = node.next;
            assertEquals(2, node.value);
            node = node.next;
            assertEquals(2001, node.value);
            node = node.next;
            assertEquals(15, node.value);

            assertEquals(15, sum_list.tail.value);
        } catch (NullPointerException e) {
            fail("list is empty");
        }
    }

    @Test
    void sumEmptyLists() {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        LinkedList sum_list = LinkedListFunction.sum(list1, list2);
        try {
            assertNull(sum_list.head);
            assertNull(sum_list.tail);
        } catch (NullPointerException e) {
            System.out.println("list is empty");
        }
    }

    @Test
    void sumDifferentLists() {
        LinkedList list1 = new LinkedList();
        list1.addInTail(new Node(1));
        LinkedList list2 = new LinkedList();
        list2.addInTail(new Node(1));
        list2.addInTail(new Node(2));
        LinkedList sum_list = LinkedListFunction.sum(list1, list2);
        try {
            assertNull(sum_list.head);
            assertNull(sum_list.tail);
        } catch (NullPointerException e) {
            System.out.println("list is empty");
        }

    }
}