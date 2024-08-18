package com.algorithms.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SimpleSinglyLinkedListTest {
    @Test
    void shouldCheckIfHeadAndTailLooped() {
        var list = new SimpleLinkedList<Integer>();
        var tail = new SimpleLinkedList.Node<>(5, null);
        var n4 = new SimpleLinkedList.Node<>(4, tail);
        var n3 = new SimpleLinkedList.Node<>(3, n4);
        var n2 = new SimpleLinkedList.Node<>(2, n3);
        var head = new SimpleLinkedList.Node<>(1, n2);
        tail.setNext(head);
        list.setHead(head);
        list.setTail(tail);
        Assertions.assertTrue(list.hasLoop());
    }

    @Test
    void shouldCheckIfLoopExistsInTheMiddle() {
        var list = new SimpleLinkedList<Integer>();
        var tail = new SimpleLinkedList.Node<>(6, null);
        var n5 = new SimpleLinkedList.Node<>(5, tail);
        var n4 = new SimpleLinkedList.Node<>(4, n5);
        var n3 = new SimpleLinkedList.Node<>(3, n4);
        var n2 = new SimpleLinkedList.Node<>(2, n3);
        var head = new SimpleLinkedList.Node<>(1, n2);
        n5.setNext(n3);
        list.setHead(head);
        list.setTail(tail);
        Assertions.assertTrue(list.hasLoop());
    }

    @Test
    void shouldCheckIfListNotLooped() {
        var list = new SimpleLinkedList<Integer>();
        var tail = new SimpleLinkedList.Node<>(6, null);
        var n5 = new SimpleLinkedList.Node<>(5, tail);
        var n4 = new SimpleLinkedList.Node<>(4, n5);
        var n3 = new SimpleLinkedList.Node<>(3, n4);
        var n2 = new SimpleLinkedList.Node<>(2, n3);
        var head = new SimpleLinkedList.Node<>(1, n2);
        list.setHead(head);
        list.setTail(tail);
        Assertions.assertFalse(list.hasLoop());
    }

    @Test
    void shouldCheckIfSingleNodeSelfLooped() {
        var list = new SimpleLinkedList<Integer>();
        var n1 = new SimpleLinkedList.Node<>(1, null);
        n1.setNext(n1);
        list.setHead(n1);
        list.setTail(n1);
        Assertions.assertTrue(list.hasLoop());
    }
}