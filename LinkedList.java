import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }


    public boolean remove(int _value) {

        Node prev = null;
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                if (prev != null) {
                    prev.next = node.next;
                    if (node.next == null) {
                        this.tail = prev;
                    }
                } else {
                    this.head = this.head.next;
                    if (this.head == null) {
                        this.tail = null;
                    }
                }
                return true; // если узел был удалён
            }
            prev = node;
            node = node.next;
        }
        return false;
    }


    public void removeAll(int _value) {
        // здесь будет ваш код удаления всех узлов по заданному значению
        Node prev = null;
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                if (prev != null) {
                    prev.next = node.next;
                    if (node.next == null) {
                        this.tail = prev;
                    }
                } else {
                    this.head = this.head.next;
                    if (this.head == null) {
                        this.tail = null;
                    }
                }
            } else {
                prev = node;
            }
            node = node.next;
        }
    }

    public void clear() {
        // здесь будет ваш код очистки всего списка
        this.head = null;
        this.tail = null;
    }

    public int count() {
        Node node = this.head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        // если _nodeAfter = null и список пустой,
        // добавьте новый элемент первым в списке
        if (_nodeAfter == null || this.head == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            if (_nodeToInsert.next == null) {
                this.tail = _nodeToInsert;
            }
            return;
        }
        // здесь будет ваш код вставки узла после заданного
        Node node = this.head;
        while (node != null) {
            if (node == _nodeAfter) {
                _nodeToInsert.next = node.next;
                node.next = _nodeToInsert;
            }
            if (_nodeToInsert.next == null) {
                this.tail = _nodeToInsert;
            }
            node = node.next;
        }
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}