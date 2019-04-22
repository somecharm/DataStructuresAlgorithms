import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void size() {
        Stack<Integer> stack = new Stack<>();
        stack.push(new Integer(0));
        stack.push(new Integer(1));
        stack.push(new Integer(2));
        assertEquals(3, stack.size());
    }

    @Test
    void sizeEmpty() {
        Stack<Object> stack = new Stack<>();
        assertEquals(0, stack.size());
    }

    @Test
    void peek() {
        Stack<Object> stack = new Stack<>();
        stack.push(new Integer(222));
        stack.push(new Integer(1));
        assertEquals(222, stack.peek());
    }

    @Test
    void peekEmpty() {
        Stack<Object> stack = new Stack<>();
        assertNull(stack.peek());
    }

    @Test
    void popEmpty() {
        Stack<Object> stack = new Stack<>();
        assertNull(stack.pop());
    }

    @Test
    void pop() {
        Stack<Object> stack = new Stack<>();
        stack.push(new Integer(0));
        stack.push(new Integer(1));
        stack.push(new Integer(2));
        stack.push(new Integer(3));
        stack.pop();
        assertEquals(1, stack.stack.get(0));
        assertEquals(2, stack.stack.get(1));
        assertEquals(3, stack.stack.get(2));
        assertEquals(3, stack.size());
    }

    @Test
    void popAll() {
        Stack<Object> stack = new Stack<>();
        stack.push(new Integer(0));
        stack.push(new Integer(1));
        stack.push(new Integer(2));
        stack.push(new Integer(3));
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals(3, stack.stack.get(0));
        assertEquals(1, stack.size());
        stack.pop();
        assertEquals(0, stack.size());
    }

    @Test
    void push() {
        Stack<Object> stack = new Stack<>();
        stack.push(new Integer(0));
        stack.push(new Integer(1));
        stack.push(new Integer(2));
        stack.push(new Integer(3));
        assertEquals(0, stack.peek());
        assertEquals(0, stack.stack.get(0));
        assertEquals(1, stack.stack.get(1));
        assertEquals(2, stack.stack.get(2));
        assertEquals(3, stack.stack.get(3));
        assertEquals(4, stack.size());
    }

    @Test
    void bracesFalse1() {
        Stack<Object> stack = new Stack<>();
        assertFalse(stack.checkBraces("(()("));
    }

    @Test
    void bracesFalse() {
        Stack<Object> stack = new Stack<>();
        assertFalse(stack.checkBraces("(()()))"));
    }

    @Test
    void bracesFalse3() {
        Stack<Object> stack = new Stack<>();
        assertFalse(stack.checkBraces(")(()())"));//
    }

    @Test
    void bracesFalse4() {
        Stack<Object> stack = new Stack<>();
        assertFalse(stack.checkBraces("((())()))"));//
    }

    @Test
    void bracesFalse5() {
        Stack<Object> stack = new Stack<>();
        assertFalse(stack.checkBraces(")(()()))"));
    }

    @Test
    void bracesTrue() {
        Stack<Object> stack = new Stack<>();
        assertTrue(stack.checkBraces("(())"));
        assertTrue(stack.checkBraces("(())()"));
        assertTrue(stack.checkBraces("()(())((()))"));
        assertTrue(stack.checkBraces("((((()()))))"));
        assertTrue(stack.checkBraces("((((()))))"));
        assertTrue(stack.checkBraces("(()())"));
    }

    @Test
    void calculate() {
        Stack<Object> stack = new Stack<>();
        stack.push(new Integer(1));
        stack.push(new Integer(2));
        stack.push(new Character('+'));
        stack.push(new Integer(3));
        stack.push(new Character('*'));
        stack.push(new Character('='));

        assertEquals(9, stack.calculate());
    }

    @Test
    void calculate2() {
        Stack<Object> stack = new Stack<>();
        stack.push(new Integer(8));
        stack.push(new Integer(2));
        stack.push(new Character('+'));
        stack.push(new Integer(5));
        stack.push(new Character('*'));
        stack.push(new Integer(9));
        stack.push(new Character('+'));
        stack.push(new Character('='));

        assertEquals(59, stack.calculate());
    }
}