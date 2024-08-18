package com.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList linkedList;

    @Test
    public void testBubbleSort() {
        linkedList = new LinkedList(5);
        linkedList.append(1);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);
        linkedList.bubbleSort();
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), linkedList.list());
    }

    @Test
    public void testSelectionSort() {
        linkedList = new LinkedList(5);
        linkedList.append(1);
        linkedList.append(4);
        linkedList.append(3);
        linkedList.append(2);
        linkedList.selectionSort();
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), linkedList.list());
    }

    @Test
    public void testInsertionSort() {
        linkedList = new LinkedList(5);
        linkedList.append(1);
        linkedList.append(4);
        linkedList.append(-11);
        linkedList.append(3);
        linkedList.append(2);
        linkedList.insertionSort();
        assertEquals(Arrays.asList(-11, 1, 2, 3, 4, 5), linkedList.list());
    }

    @Test
    void testInsertionSort_oneElement() {
        LinkedList list = new LinkedList(1);
        list.insertionSort();
        assertNotNull(list);
        assertEquals(1, list.getLength());
        assertEquals(1, list.getHead().value);
    }

    @Test
    void testInsertionSort_twoElement_inOrder() {
        LinkedList list = new LinkedList(1);
        list.append(2);
        list.insertionSort();
        assertNotNull(list);
        assertEquals(2, list.getLength());
        assertEquals(1, list.getHead().value);
        assertEquals(2, list.getTail().value);
        assertEquals(Arrays.asList(1, 2), list.list());

    }

    @Test
    void testInsertionSort_twoElement_outOfOrder() {
        LinkedList list = new LinkedList(2);
        list.append(1);
        list.insertionSort();
        assertNotNull(list);
        assertEquals(2, list.getLength());
        assertEquals(1, list.getHead().value);
        assertEquals(2, list.getTail().value);
        assertEquals(Arrays.asList(1, 2), list.list());
    }

    @Test
    void testInsertionSort_multipleElement_randomOrder() {
        LinkedList list = new LinkedList(5);
        list.append(2);
        list.append(4);
        list.append(1);
        list.append(3);
        list.insertionSort();
        assertNotNull(list);
        assertEquals(5, list.getLength());
        assertEquals(1, list.getHead().value);
        assertEquals(5, list.getTail().value);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list.list());
    }

    @Test
    void testInsertionSort_multipleElement_inOrder() {
        LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.insertionSort();
        assertNotNull(list);
        assertEquals(5, list.getLength());
        assertEquals(1, list.getHead().value);
        assertEquals(5, list.getTail().value);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list.list());
    }

    @Test
    void testInsertionSort_multipleElement_reverseOrder() {
        LinkedList list = new LinkedList(5);
        list.append(4);
        list.append(3);
        list.append(2);
        list.append(1);
        list.insertionSort();
        assertNotNull(list);
        assertEquals(5, list.getLength());
        assertEquals(1, list.getHead().value);
        assertEquals(5, list.getTail().value);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list.list());
    }

    @Test
    void testInsertionSort_insertAtEndOfSortedList() {
        LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(3);
        list.append(0);
        list.insertionSort();

        assertNotNull(list);
        assertEquals(4, list.getLength());
        assertEquals(0, list.getHead().value);
        assertEquals(3, list.getTail().value);
        assertEquals(Arrays.asList(0, 1, 2, 3), list.list());
    }

    @Test
    void testInsertionSort_maintainPrevAndCurPointers() {
        LinkedList list = new LinkedList(3);
        list.append(2);
        list.append(6);
        list.append(5);
        list.append(1);
        list.append(3);
        list.insertionSort();

        assertEquals(Arrays.asList(1, 2, 3, 3, 5, 6), list.list());
    }

    @Test
    void testInsertionSort_handleDuplicates() {
        LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(3);
        list.append(3);
        list.append(3);
        list.append(2);
        list.append(1);
        list.insertionSort();

        assertNotNull(list);
        assertEquals(7, list.getLength());
        assertEquals(1, list.getHead().value);
        assertEquals(3, list.getTail().value);

        // Test list order
        assertEquals(Arrays.asList(1, 1, 2, 2, 3, 3, 3), list.list());
    }

    @Test
    void testInsertionSort_sorted() {
        LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.insertionSort();

        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), list.list());
    }



}