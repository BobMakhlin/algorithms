package com.algorithms.stack;

import java.util.Comparator;

public class StackUtils {
    private StackUtils() {
    }

    public static <E> void sort(Stack<E> stack, Comparator<E> comparator) {
        var sortedStack = new Stack<E>();
        while (!stack.isEmpty()) {
            var element = stack.pop();

            while (!sortedStack.isEmpty()
                    && comparator.compare(element, sortedStack.peek()) < 0) {
                var top = sortedStack.pop();
                stack.push(top);
            }
            sortedStack.push(element);
        }

        while (!sortedStack.isEmpty()) {
            stack.push(sortedStack.pop());
        }
    }
}
