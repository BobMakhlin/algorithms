package com.algorithms.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    public void testPush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        assertFalse(stack.isEmpty(), "Stack should not be empty after push");
        assertEquals(1, stack.peek(), "Top element should be 1");

        stack.push(2);
        assertEquals(2, stack.peek(), "Top element should be 2 after second push");
    }

    @Test
    public void testPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop(), "Pop should return 2");
        assertFalse(stack.isEmpty(), "Stack should not be empty after one pop");

        assertEquals(1, stack.pop(), "Pop should return 1");
        assertTrue(stack.isEmpty(), "Stack should be empty after popping all elements");
    }

    @Test
    public void testPeek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.peek(), "Peek should return 2");
        assertFalse(stack.isEmpty(), "Stack should not be empty after peek");

        stack.pop();
        assertEquals(1, stack.peek(), "Peek should return 1 after popping");
    }

    @Test
    public void testEquals_sameStacks_returnTrue() {
        Stack<Integer> stack1 = Stack.of(1, 2, 3, 4, 5);
        Stack<Integer> stack2 = Stack.of(1, 2, 3, 4, 5);
        assertTrue(stack1.equals(stack2), "Equal stacks should return true");
    }

    @Test
    public void testEquals_differentStacks_returnFalse() {
        Stack<Integer> stack1 = Stack.of(1, 2, 3, 4, 5);
        Stack<Integer> stack2 = Stack.of(1, 2, 3, 4, 6);
        assertFalse(stack1.equals(stack2), "Different stacks should return false");
    }

    @Test
    public void testEquals_withItsSelf_returnTrue() {
        Stack<Integer> stack1 = Stack.of(1, 2, 3, 4, 5);
        assertTrue(stack1.equals(stack1), "A stack tested with itself should return true");
    }

    @Test
    public void testEquals_withNull_returnFalse() {
        Stack<Integer> stack1 = Stack.of(1, 2, 3, 4, 5);
        Stack<Integer> stack2 = null;
        assertFalse(stack1.equals(stack2), "A stack tested with null should return false");
    }
}
