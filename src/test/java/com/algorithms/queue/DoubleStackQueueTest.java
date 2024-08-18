package com.algorithms.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DoubleStackQueueTest {
    private DoubleStackQueue<Integer> queue;

    @BeforeEach
    public void setUp() {
        queue = new DoubleStackQueue<>();
    }

    @Test
    public void testIsEmptyInitially() {
        assertTrue(queue.isEmpty(), "Queue should be empty initially");
    }

    @Test
    public void testEnqueueAndIsEmpty() {
        queue.enqueue(1);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueue");
    }

    @Test
    public void testPeekSingleElement() {
        queue.enqueue(1);
        assertEquals(1, queue.peek(), "Peek should return the first element enqueued");
    }

    @Test
    public void testEnqueueMultipleElements() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.peek(), "Peek should return the first element enqueued");
    }

    @Test
    public void testPeekDoesNotRemoveElement() {
        queue.enqueue(1);
        queue.peek();
        assertFalse(queue.isEmpty(), "Peek should not remove the element from the queue");
    }

    @Test
    public void testPeekEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> {
            queue.peek();
        }, "Peek should throw NoSuchElementException when the queue is empty");
    }

    @Test
    public void testEnqueueNullElement() {
        queue.enqueue(null);
        assertNull(queue.peek(), "Peek should return null if null was enqueued");
    }

    @Test
    public void testOrderPreservation() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.peek(), "Peek should return the first element enqueued");
    }

    @Test
    public void testDequeueSingleElement() {
        queue.enqueue(1);
        assertEquals(1, queue.dequeue(), "Dequeue should return the first element enqueued");
        assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing the only element");
    }

    @Test
    public void testDequeueMultipleElements() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        assertEquals(1, queue.dequeue(), "Dequeue should return the first element enqueued");
        assertEquals(2, queue.dequeue(), "Dequeue should return the second element enqueued");
        assertEquals(3, queue.dequeue(), "Dequeue should return the third element enqueued");
        assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing all elements");
    }

    @Test
    public void testDequeueEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> {
            queue.dequeue();
        }, "Dequeue should throw NoSuchElementException when the queue is empty");
    }

    @Test
    public void testPeekAndThenEnqueueAndDequeue() {
        queue.enqueue(1);
        assertEquals(1, queue.peek(), "Peek should return the first element enqueued");
        queue.enqueue(2);
        assertEquals(1, queue.dequeue(), "Dequeue should return the first element enqueued after peek");
        assertEquals(2, queue.dequeue(), "Dequeue should return the second element enqueued after peek");
        assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing all elements");
    }
}