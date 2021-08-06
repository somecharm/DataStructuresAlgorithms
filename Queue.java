import java.util.*;

public class Queue<T> {
    LinkedList<T> queue;

    public Queue() {
        // инициализация внутреннего хранилища очереди
        queue = new LinkedList<>();
    }

    public void enqueue(T item) {
        // вставка в хвост
        queue.addLast(item);
    }

    public T dequeue() {
        // выдача из головы
        if (queue.size() > 0) {
            T element = queue.removeFirst();
            return element;
        }
        return null; // null если очередь пустая
    }

    public int size() {
        return queue.size(); // размер очереди
    }

    public void rotate(int n) {
        for (int i = 0; i < n; i++) {
            enqueue(dequeue());
        }
    }
}