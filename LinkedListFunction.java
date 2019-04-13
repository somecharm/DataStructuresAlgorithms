public class LinkedListFunction extends LinkedList {

    public static LinkedList sum(LinkedList list1, LinkedList list2) {

        LinkedList sum_list = new LinkedList();
        Node node1 = list1.head;
        Node node2 = list2.head;
        while (node1 != null && node2 != null) {
            sum_list.addInTail(new Node(node1.value + node2.value));
            node1 = node1.next;
            node2 = node2.next;
        }
        if (node1 != null || node2 != null) {
            return null; // если списки разной длины
        }
        return sum_list;
    }
}

