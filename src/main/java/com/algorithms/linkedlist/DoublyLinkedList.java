package com.algorithms.linkedlist;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@NoArgsConstructor
public class DoublyLinkedList<E> implements Iterable<E> {
    private Node head;
    private Node tail;
    private int size;

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    public void append(E val) {
        var node = new Node(val, null, null);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    public boolean removeLast() {
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            head = tail = null;
            size = 0;
            return true;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
        return true;
    }

    public void prepend(E val) {
        var node = new Node(val, null, null);
        if (size == 0) {
            head = tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        size++;
    }

    public boolean removeFirst() {
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            head = tail = null;
            size = 0;
            return true;
        }
        head = head.next;
        head.prev = null;
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public List<E> toList() {
        var lst = new ArrayList<E>();
        for (var el : this) {
            lst.add(el);
        }
        return lst;
    }

    public E get(int index) {
        return getNode(index).data;
    }

    public void set(int index, E val) {
        var t = getNode(index);
        t.data = val;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        var middleNodeIndex = size / 2;
        if (index >= middleNodeIndex) {
            var cur = tail;
            var i = size - 1;
            while (i > index) {
                cur = cur.prev;
                i--;
            }
            return cur;
        }
        var cur = head;
        var i = 0;
        while (i < index) {
            cur = cur.next;
            i++;
        }
        return cur;
    }

    public void insert(int index, E val) {
        if (index == 0) {
            prepend(val);
            return;
        }
        if (index == size) {
            append(val);
            return;
        }
        var nextNode = getNode(index);
        var prevNode = nextNode.prev;
        var newNode = new Node(val, prevNode, nextNode);
        prevNode.next = newNode;
        nextNode.prev = newNode;
        size++;
    }

    public void remove(int index) {
        if (index == 0) {
            if (!removeFirst()) {
                throw new IndexOutOfBoundsException();
            }
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        var node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public void swapFirstAndLast() {
        if (size < 2) {
            return;
        }
        var headData = head.data;
        head.data = tail.data;
        tail.data = headData;
    }

    public void reverse() {
        if (size < 2) {
            return;
        }
        var cur = head;
        while (cur != null) {
            var nextNode = cur.next;
            cur.next = cur.prev;
            cur.prev = nextNode;
            cur = nextNode;
        }
        var tmp = head;
        head = tail;
        tail = tmp;
    }

    public boolean isPalindrome() {
        if (size == 0) {
            return false;
        }
        var left = head;
        var right = tail;
        while (left != right) {
            if (!left.data.equals(right.data)) {
                return false;
            }
            left = left.next;
            right = right.prev;
        }
        return true;
    }

    public void swapPairs() {
        if (size < 2) {
            return;
        }
        Node previousNode = null;
        var currentNode = head;
        var nextNode = currentNode.next;
        var nextNodeOfNext = nextNode.next;

        while (currentNode != null && nextNode != null) {
            // Update previous node.
            if (previousNode != null) {
                previousNode.next = nextNode;
            }
            nextNode.prev = previousNode;
            // Update the next of the next.
            currentNode.next = nextNodeOfNext;
            if (nextNodeOfNext != null) {
                nextNodeOfNext.prev = currentNode;
            }
            // Swap the pair.
            currentNode.prev = nextNode;
            nextNode.next = currentNode;

            currentNode = nextNodeOfNext;
            if (currentNode != null) {
                previousNode = currentNode.prev;
                nextNode = currentNode.next;
                nextNodeOfNext = nextNode != null ? nextNode.next : null;
            }
        }

        head = head.prev;
        if (tail.next != null) {
            // If there's an even count of items in the list, the _last pair_ was swapped,
            // and the tail reference must be moved.
            tail = tail.next;
        }
    }

    @AllArgsConstructor
    private class Node {
        private E data;
        private Node prev;
        private Node next;
    }

    private class Itr implements Iterator<E> {
        private Node cur;

        @Override
        public boolean hasNext() {
            return DoublyLinkedList.this.size > 0
                    && cur != DoublyLinkedList.this.tail;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (cur == null) {
                cur = DoublyLinkedList.this.head;
            } else {
                cur = cur.next;
            }
            return cur.data;
        }
    }
}
