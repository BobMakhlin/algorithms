package com.algorithms.linkedlist;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.*;

@NoArgsConstructor
public class SinglyLinkedList<E extends Comparable<E>> implements Iterable<E> {
    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return size;
    }

    /**
     * Expects both linked lists are sorted in ascending way.
     * Merges the given one into this linked list.
     */
    public void mergeSorted(SinglyLinkedList<E> list2) {
        if (head == null) {
            head = list2.head;
            return;
        }
        if (list2.head == null) {
            return;
        }
        Node mergedListTail;
        var list1CurrentNode = head;
        var list2CurrentNode = list2.head;

        if (list2CurrentNode.data.compareTo(list1CurrentNode.data) < 0) {
            head = list2CurrentNode;
            mergedListTail = list2CurrentNode;
            list2CurrentNode = list2CurrentNode.next;
        } else {
            mergedListTail = list1CurrentNode;
            list1CurrentNode = list1CurrentNode.next;
        }

        while (list1CurrentNode != null && list2CurrentNode != null) {
            if (list2CurrentNode.data.compareTo(list1CurrentNode.data) < 0) {
                mergedListTail.next = list2CurrentNode;
                mergedListTail = list2CurrentNode;
                list2CurrentNode = list2CurrentNode.next;
            } else {
                mergedListTail.next = list1CurrentNode;
                mergedListTail = list1CurrentNode;
                list1CurrentNode = list1CurrentNode.next;
            }
        }

        if (list1CurrentNode != null) {
            mergedListTail.next = list1CurrentNode;
        }
        if (list2CurrentNode != null) {
            mergedListTail.next = list2CurrentNode;
            tail = list2.tail;
        }

        size = size + list2.size;
    }

    public void prepend(E el) {
        var node = new Node(el, null);
        if (size == 0) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }

    public void append(E el) {
        var node = new Node(el, null);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
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
        var secondToLast = head;
        while (secondToLast.next != tail) {
            secondToLast = secondToLast.next;
        }
        secondToLast.next = null;
        tail = secondToLast;
        size--;
        return true;
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
        size--;
        return true;
    }

    public E get(int index) {
        return getNode(index).data;
    }

    public void set(int index, E val) {
        var t = getNode(index);
        t.data = val;
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
        var prevNode = getNode(index - 1);
        var nextNode = prevNode.next;
        prevNode.next = new Node(val, nextNode);
        size++;
    }

    public void reverse() {
        if (size <= 1) {
            return;
        }
        var cur = head;
        var next = cur.next;
        var nnv = next.next;
        while (next != null) {
            next.next = cur;
            cur = next;
            next = nnv;
            if (next != null) {
                nnv = next.next;
            }
        }
        head.next = null;
        var tmp = head;
        head = tail;
        tail = tmp;
    }

    public E findMiddle() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
        // Floyd's Tortoise and Hare algorithm.
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == null) {
            return null;
        }
        // When fast is in the end, slow is in the middle.
        return slow.data;
    }

    public E findByIndexFromEnd(int endIndex) {
        // Task: don't use length.
        var fast = head;
        var index = 0;
        while (index < endIndex) {
            index++;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
        }
        var slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public void partitionBy(E pivot, Comparator<E> comparator) {
        // Task: tail cannot be used.
        Node leftChainHead = null;
        Node leftChainCurrent = null;
        Node rightChainHead = null;
        Node rightChainCurrent = null;

        var cur = head;
        while (cur != null) {
            if (comparator.compare(cur.data, pivot) < 0) {
                if (leftChainHead == null) {
                    leftChainHead = cur;
                } else {
                    leftChainCurrent.next = cur;
                }
                leftChainCurrent = cur;
            } else {
                if (rightChainHead == null) {
                    rightChainHead = cur;
                } else {
                    rightChainCurrent.next = cur;
                }
                rightChainCurrent = cur;
            }

            cur = cur.next;
        }

        head = leftChainHead;
        leftChainCurrent.next = rightChainHead;
        tail = rightChainCurrent;
        tail.next = null;
    }

    public void removeDuplicates() {
        if (size < 2) {
            return;
        }
        var set = new HashSet<E>();
        set.add(head.data);
        var cur = head;
        var next = cur.next;

        while (next != null) {
            var isDuplicate = !set.add(next.data);
            if (isDuplicate) {
                size--;
                cur.next = next.next;
                next = next.next;
            } else {
                cur = cur.next;
                next = cur.next;
            }
        }
        tail = cur;
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= size || startIndex >= endIndex) {
            throw new IllegalArgumentException("Invalid indexes");
        }
        var prevToSubchain = startIndex == 0 ? null : getNode(startIndex - 1);
        var subchainFirst = startIndex == 0 ? head : prevToSubchain.next;

        var cur = subchainFirst;
        var next = cur.next;
        var nnv = next.next;
        var index = startIndex;
        while (index != endIndex && next != null) {
            next.next = cur;
            cur = next;
            next = nnv;
            if (next != null) {
                nnv = next.next;
            }
            index++;
        }
        var subchainLast = cur;
        var nextAfterSubchain = next;

        if (startIndex == 0) {
            head = subchainLast;
        } else {
            prevToSubchain.next = subchainLast;
        }
        if (endIndex == size - 1) {
            tail = subchainFirst;
        }
        subchainFirst.next = nextAfterSubchain;
    }

    public List<E> toList() {
        var lst = new ArrayList<E>();
        for (var el : this) {
            lst.add(el);
        }
        return lst;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }

    public E last() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        return tail.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private Node getNode(int index) {
        if (size == 0) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index == size - 1) {
            return tail;
        }
        var cur = head;
        var i = 0;
        while (cur.next != null) {
            if (i++ == index) {
                return cur;
            }
            cur = cur.next;
        }
        throw new IndexOutOfBoundsException(index);
    }

    @AllArgsConstructor
    private class Node {
        private E data;
        private Node next;
    }

    private class Itr implements Iterator<E> {
        private Node cur;

        @Override
        public boolean hasNext() {
            return SinglyLinkedList.this.size > 0
                    && cur != SinglyLinkedList.this.tail;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (cur == null) {
                cur = SinglyLinkedList.this.head;
            } else {
                cur = cur.next;
            }
            return cur.data;
        }
    }
}
