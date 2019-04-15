import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                return node;
            }
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
        Node node = this.head;
        if (node != null) {
            node.prev = null;
        }
        while (node != null) {
            if (node.value == _value) {
                if (node.prev != null) {
                    if (node.next != null) {
                        node.prev.next = node.next;
                        node.next.prev = node.prev;

                    } else { //last
                        this.tail = node.prev;
                        node.prev.next = null;
                    }
                } else {
                    this.head = this.head.next;
                    if (node.next != null) {
                        node.next.prev = null;
                    }
//
                    if (this.head == null) {
                        this.tail = null;
                    }
                }
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        // здесь будет ваш код удаления всех узлов по заданному значению
        Node node = this.head;
        if (node != null) {
            node.prev = null;
        }
        while (node != null) {
            if (node.value == _value) {
                if (node.prev != null) {
                    if (node.next != null) {
                        node.prev.next = node.next;
                        node.next.prev = node.prev;

                    } else {
                        this.tail = node.prev;
                        node.prev.next = null;
                    }
                } else {
                    this.head = node.next;
                    if (node.next != null) {
                        node.next.prev = null;
                    }
                    if (this.head == null) {
                        this.tail = null;
                    }
                }
            }
            node = node.next;
        }
    }

    public void clear() {
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
        // здесь будет ваш код вставки узла после заданного узла

        // если _nodeAfter = null
        // добавьте новый элемент первым в списке
        if (_nodeAfter == null || this.head == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            if (_nodeToInsert.next == null) {
                this.tail = _nodeToInsert;
            }
            return;
        }

        Node node = this.head;
        while (node != null) {
            if (node == _nodeAfter) {
                if (node.next != null) {
                    node.next.prev = _nodeToInsert;
                }
                _nodeToInsert.next = node.next;
                _nodeToInsert.prev = node;
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
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}