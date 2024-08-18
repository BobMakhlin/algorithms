package com.algorithms.queue;

import com.algorithms.linkedlist.SinglyLinkedList;

public class Queue<E extends Comparable<E>> {
    private final SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public void enqueue(E element) {
        list.append(element);
    }

    public E dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        var first = list.first();
        list.removeFirst();
        return first;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public E peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.first();
    }
}
