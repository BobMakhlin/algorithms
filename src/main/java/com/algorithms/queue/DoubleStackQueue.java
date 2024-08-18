package com.algorithms.queue;

import com.algorithms.stack.Stack;

public class DoubleStackQueue<E> {
    private final Stack<E> stack1 = new Stack<>();
    private final Stack<E> stack2 = new Stack<>();

    public void enqueue(E e) {
        stack2.push(e);
    }

    public E dequeue() {
        if (stack1.isEmpty()) {
            doLazyLoad();
        }
        return stack1.pop();
    }

    public E peek() {
        if (stack1.isEmpty()) {
            doLazyLoad();
        }
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void doLazyLoad() {
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
}
