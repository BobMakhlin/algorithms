package com.algorithms.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackUtilsTest {
    @Test
    public void testSortEmptyStack() {
        Stack<Integer> stack = new Stack<>();
        StackUtils.<Integer>sort(stack, Integer::compareTo);
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testSortSingleElementStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        StackUtils.<Integer>sort(stack, Integer::compareTo);
        assertEquals(Stack.of(1), stack);
    }

    @Test
    public void testSortAlreadySortedStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        StackUtils.<Integer>sort(stack, Integer::compareTo);
        assertEquals(Stack.of(3, 2, 1), stack);
    }

    @Test
    public void testSortDescendingStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        StackUtils.<Integer>sort(stack, Integer::compareTo);
        assertEquals(Stack.of(3, 2, 1), stack);
    }

    @Test
    public void testSortUnsortedStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(8);
        stack.push(0);
        stack.push(10);
        StackUtils.<Integer>sort(stack, Integer::compareTo);
        assertEquals(Stack.of(10, 8, 4, 0), stack);
    }

    @Test
    public void testSortWithDuplicates() {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(1);
        StackUtils.<Integer>sort(stack, Integer::compareTo);
        assertEquals(Stack.of(3, 2, 1, 1), stack);
    }
}