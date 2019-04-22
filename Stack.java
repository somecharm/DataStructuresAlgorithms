import java.util.*;

public class Stack<T> {
    LinkedList<T> stack;

    public Stack() {
        // инициализация внутреннего хранилища стека
        stack = new LinkedList<>();
    }

    public int size() {
        // размер текущего стека
        return stack.size();
    }

    public T pop() {
        T element = peek();
        if (element != null) {
            stack.removeFirst();
            return element;
        }
        return null;  // если стек пустой
    }

    public void push(T val) {
        stack.addLast(val);
    }

    public T peek() {
        if (stack.size() > 0) {
            return stack.getFirst();
        }
        return null; // если стек пустой
    }

    public boolean checkBraces(String str) {
        char ca[] = str.toCharArray();

        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == '(') {
                stack.push((T) "(");
            } else if (ca[i] == ')') {
                if (stack.size() > 0) {
                    stack.pop();
                } else return false;
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }

    public Integer calculate() {
        Stack<Integer> stack2 = new Stack<>();
        while (stack.size() > 0) {
            if (stack.peek().getClass() == Integer.class) {
                stack2.push((Integer) stack.pop());
            } else if (stack.peek().equals('+')) {
                stack2.push(stack2.pop() + stack2.pop());
                stack.pop();
            } else if (stack.peek().equals('*')) {
                stack2.push(stack2.pop() * stack2.pop());
                stack.pop();
            } else if (stack.peek().equals('=')) {
                stack.pop();
                return stack2.peek();
            }
        }
        return 0;
    }
}

