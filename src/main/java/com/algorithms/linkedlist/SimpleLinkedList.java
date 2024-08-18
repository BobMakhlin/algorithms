package com.algorithms.linkedlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;

    public boolean hasLoop() {
        if (head == null || tail == null) {
            return false;
        }
        // Floyd's Tortoise and Hare algorithm.
        // Fast moves 2 times faster than slow.
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    public static class Node<E> {
        private E data;
        private Node<E> next;
    }
}
