
package com.algorithms.heap;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HeapTest {
    @Nested
    class MaxHeap {
        private Heap heap;

        @BeforeEach
        void setUp() {
            heap = new Heap(true);
        }

        @Test
        void testInsertSingleElement() {
            heap.insert(10);
            assertEquals(10, heap.peek());
        }

        @Test
        void testInsertMultipleElements() {
            heap.insert(10);
            heap.insert(20);
            assertEquals(20, heap.peek());

            heap.insert(15);
            heap.insert(4);
            heap.insert(5);
            heap.insert(3);
            heap.insert(2);
            heap.insert(1);
            assertEquals(20, heap.peek());
        }

        @Test
        void testInsertSmallerElement() {
            heap.insert(20);
            heap.insert(10);
            assertEquals(20, heap.peek());
        }

        @Test
        void testEmptyHeap() {
            assertThrows(NoSuchElementException.class, () -> heap.peek());
        }

        @Test
        void testRemoveTopSingleElement() {
            heap.insert(10);
            heap.removeTop();
            assertThrows(NoSuchElementException.class, () -> heap.peek());
        }

        @Test
        void testRemoveTopMultipleElements() {
            heap.insert(10);
            heap.insert(20);
            heap.insert(15);
            heap.removeTop();
            heap.removeTop();
            heap.removeTop();
            assertThrows(NoSuchElementException.class, () -> heap.peek());
        }

        @Test
        void testRemoveTopComplex() {
            List<Integer> elements = List.of(45, 20, 15, 30, 10, 5, 50);
            elements.forEach(heap::insert);

            assertEquals(50, heap.peek());
            heap.removeTop();
            assertEquals(45, heap.peek());
            heap.removeTop();
            assertEquals(30, heap.peek());
            heap.removeTop();
            assertEquals(20, heap.peek());
            heap.removeTop();
            assertEquals(15, heap.peek());
            heap.removeTop();
            assertEquals(10, heap.peek());
            heap.removeTop();
            assertEquals(5, heap.peek());
            heap.removeTop();
            assertThrows(NoSuchElementException.class, () -> heap.peek());
        }
    }

    @Nested
    class MinHeap {
        private Heap heap;

        @BeforeEach
        void setUp() {
            heap = new Heap(false);
        }

        @Test
        void testInsertSingleElement() {
            heap.insert(10);
            assertEquals(10, heap.peek());
        }

        @Test
        void testInsertMultipleElements() {
            heap.insert(10);
            heap.insert(20);
            assertEquals(10, heap.peek());

            heap.insert(15);
            heap.insert(4);
            heap.insert(5);
            heap.insert(3);
            heap.insert(2);
            heap.insert(1);
            assertEquals(1, heap.peek());
        }

        @Test
        void testInsertSmallerElement() {
            heap.insert(20);
            heap.insert(10);
            assertEquals(10, heap.peek());
        }

        @Test
        void testEmptyHeap() {
            assertThrows(NoSuchElementException.class, () -> heap.peek());
        }

        @Test
        void testRemoveTopSingleElement() {
            heap.insert(10);
            heap.removeTop();
            assertThrows(NoSuchElementException.class, () -> heap.peek());
        }

        @Test
        void testRemoveTopMultipleElements() {
            heap.insert(10);
            heap.insert(20);
            heap.insert(15);
            heap.removeTop();
            heap.removeTop();
            heap.removeTop();
            assertThrows(NoSuchElementException.class, () -> heap.peek());
        }

        @Test
        void testRemoveTopComplex() {
            List<Integer> elements = List.of(45, 20, 15, 30, 10, 5, 50);
            elements.forEach(heap::insert);

            assertEquals(5, heap.peek());
            heap.removeTop();
            assertEquals(10, heap.peek());
            heap.removeTop();
            assertEquals(15, heap.peek());
            heap.removeTop();
            assertEquals(20, heap.peek());
            heap.removeTop();
            assertEquals(30, heap.peek());
            heap.removeTop();
            assertEquals(45, heap.peek());
            heap.removeTop();
            assertEquals(50, heap.peek());
            heap.removeTop();
            assertThrows(NoSuchElementException.class, () -> heap.peek());
        }
    }
}
