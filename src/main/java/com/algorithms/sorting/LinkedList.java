package com.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public List<Integer> list() {
        var lst = new ArrayList<Integer>();
        Node temp = head;
        while (temp != null) {
            lst.add(temp.value);
            temp = temp.next;
        }
        return lst;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void bubbleSort() {
        if (length < 2) {
            return;
        }
        for (var i = 1; i <= length; i++) {
            var swappedAtLeastOnce = false;
            var j = 0;

            var cur = head;
            while (cur.next != null && j < length - i) {
                if (cur.value > cur.next.value) {
                    swapValues(cur, cur.next);
                    swappedAtLeastOnce = true;
                }
                cur = cur.next;
                j++;
            }

            if (!swappedAtLeastOnce) {
                return;
            }
        }
    }

    public void selectionSort() {
        if (length < 2) {
            return;
        }
        var lastSorted = head;
        for (var i = 0; i < length; i++) {
            var minNode = lastSorted;
            var cur = lastSorted.next;
            for (var j = i + 1; j < length; j++) {
                if (cur.value < minNode.value) {
                    minNode = cur;
                }
                cur = cur.next;
            }
            if (minNode != lastSorted) {
                swapValues(minNode, lastSorted);
            }
            lastSorted = lastSorted.next;
        }
    }

    // o(n^2)
    public void insertionSort() {
        if (length < 2) {
            return;
        }
        var sortedListHead = head;
        var sortedListTail = head;

        var currentNode = head.next;
        var lastSortedNode = head;

        while (currentNode != null) {
            if (currentNode.value < sortedListHead.value) {
                // Current node becomes head.
                lastSortedNode.next = currentNode.next;
                currentNode.next = sortedListHead;
                sortedListHead = currentNode;
            } else if (currentNode.value >= sortedListTail.value) {
                // Current node becomes tail.
                sortedListTail = currentNode;
            } else {
                lastSortedNode.next = currentNode.next;
                placeNodeInSortedList(sortedListHead, sortedListTail, currentNode);
            }

            lastSortedNode = sortedListTail;
            currentNode = sortedListTail.next;
        }

        head = sortedListHead;
        tail = sortedListTail;
    }

    private static void placeNodeInSortedList(Node sortedListHead, Node sortedListTail, Node node) {
        var cur = sortedListHead;
        while (cur != sortedListTail && cur.next.value <= node.value) {
            cur = cur.next;
        }
        var next = cur.next;
        cur.next = node;
        node.next = next;
    }

    private static void swapValues(Node a, Node b) {
        var temp = a.value;
        a.value = b.value;
        b.value = temp;
    }
}