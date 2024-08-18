package com.algorithms.stack;


import java.util.ArrayList;
import java.util.Objects;

public class Stack<E> {
    private final ArrayList<E> items = new ArrayList<>();

    public void push(E val) {
        items.add(val);
    }

    public E pop() {
        if (items.isEmpty()) {
            return null;
        }
        return items.remove(items.size() - 1);
    }

    public E peek() {
        if (items.isEmpty()) {
            return null;
        }
        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    @SafeVarargs
    public static <E> Stack<E> of(E... params) {
        var s = new Stack<E>();
        for (var e : params) {
            s.push(e);
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stack<?> stack = (Stack<?>) o;
        return Objects.equals(items, stack.items);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(items);
    }
}
