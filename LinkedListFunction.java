public class LinkedListFunction extends LinkedList {

    // Первый способ
    public static LinkedList sum(LinkedList list1, LinkedList list2) {
        int n = list1.count();
        if (n == list2.count()) {
            LinkedList sum_list = new LinkedList();
            Node node1 = list1.head;
            Node node2 = list2.head;
            while (n > 0) {
                sum_list.addInTail(new Node(node1.value + node2.value));
                node1 = node1.next;
                node2 = node2.next;
                n--;
            }
            return sum_list;
        }
        return null; // если списки разной длины
    }

    // Второй способ
    public static LinkedList sum2(LinkedList list1, LinkedList list2) {

        if (list1.count() == list2.count()) {
            Node node1 = list1.head;
            Node node2 = list2.head;

            while (node1 != null) {
                node1.value = node1.value + node2.value;
                node1 = node1.next;
                node2 = node2.next;
            }
            return list1;
        }
        return null; // если списки разной длины
    }

}

