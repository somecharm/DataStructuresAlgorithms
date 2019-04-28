import java.util.*;

public class Deque<T> {
    LinkedList<T> deque;

    public Deque() {
        // инициализация внутреннего хранилища
        deque = new LinkedList<>();
    }

    public void addFront(T item) {
        // добавление в голову
        deque.addFirst(item);
    }

    public void addTail(T item) {
        // добавление в хвост
        deque.addLast(item);
    }

    public T removeFront() {
        // удаление из головы
        if (deque.getFirst() != null) {
            return deque.removeFirst();
        }
        return null;
    }

    public T removeTail() {
        // удаление из хвоста
        if (deque.getLast() != null) {
            return deque.removeLast();
        }
        return null;
    }

    public int size() {
        return deque.size(); // размер очереди
    }

    public boolean palindromo(String str) {
        deque.addAll((Collection<? extends T>) Arrays.asList(str.split("")));

        while (deque.size() > 1) {
            if (!removeFront().equals(removeTail())) {
                return false;
            }
        }
        return true;
    }
}