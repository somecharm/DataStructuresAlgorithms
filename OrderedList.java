import java.util.*;


class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;
    public int count;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
        count = 0;
    }

    public int compare(T v1, T v2) {
        if (v1.getClass() == Integer.class && v2.getClass() == Integer.class) {
            if ((Integer) v1 > (Integer) v2) {
                return 1;
            } else if ((Integer) v1 < (Integer) v2) {
                return -1;
            }

        } else if (v1.getClass() == String.class && v2.getClass() == String.class) {
            if (v1.toString().trim().compareTo(v2.toString().trim()) > 0) {
                return 1;
            } else if (v1.toString().trim().compareTo(v2.toString().trim()) < 0) {
                return -1;
            }
        }
        return 0;
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
    }

    public void add(T value) {
        // автоматическая вставка value
        // в нужную позицию
        Node<T> _nodeToInsert = new Node<T>(value);
        if (head == null) {
            head = _nodeToInsert;
            tail = head;

        } else if ((_ascending && compare(value, head.value) <= 0) || (!_ascending && compare(value, head.value) >= 0)) {
            _nodeToInsert.next = head;
            head.prev = _nodeToInsert;
            head = _nodeToInsert;

        } else if ((_ascending && compare(value, tail.value) >= 0) || (!_ascending && compare(value, tail.value) <= 0)) {
            _nodeToInsert.prev = tail;
            tail.next = _nodeToInsert;
            tail = _nodeToInsert;

        } else {
            Node<T> node = head;
            while (node != null) {
                if ((_ascending && compare(value, node.next.value) <= 0) || (!_ascending && compare(value, node.next.value) >= 0)) {
                    node.next.prev = _nodeToInsert;
                    _nodeToInsert.next = node.next;
                    _nodeToInsert.prev = node;
                    node.next = _nodeToInsert;
                    return;
                }
                node = node.next;
            }
        }
    }

    public Node<T> find(T val) {
        if (val != null && head != null) {
            Node<T> node = head;
            while (node != null) {
                if (node.value == val) {
                    return node;
                }
                if ((_ascending && compare(node.value, val) == 1) || (!_ascending && compare(node.value, val) == -1)) {
                    return null;
                }
                node = node.next;
            }
        }
        return null;
    }

    public void delete(T val) {
        // здесь будет ваш код
        Node<T> node = head;
        if (node != null) {
            node.prev = null;
        }
        while (node != null) {
            if (node.value == val) {
                if (node.prev != null) {
                    if (node.next != null) {
                        node.prev.next = node.next;
                        node.next.prev = node.prev;

                    } else {
                        this.tail = node.prev;
                        node.prev.next = null;
                    }
                } else {
                    head = head.next;
                    if (node.next != null) {
                        node.next.prev = null;
                    }
//
                    if (head == null) {
                        tail = null;
                    }
                }
                return;
            }
            node = node.next;
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        head = null;
        tail = null;
    }

    public int count() {
        Node<T> node = head;
        int count = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}
