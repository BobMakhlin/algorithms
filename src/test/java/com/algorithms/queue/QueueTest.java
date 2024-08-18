package com.algorithms.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    public void testEnqueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        assertFalse(queue.isEmpty(), "Queue should not be empty after enqueue");
        assertEquals(1, queue.peek(), "Front element should be 1");

        queue.enqueue(2);
        assertEquals(1, queue.peek(), "Front element should still be 1 after enqueuing 2");
    }

    @Test
    public void testDequeue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, queue.dequeue(), "Dequeue should return 1");
        assertFalse(queue.isEmpty(), "Queue should not be empty after one dequeue");

        assertEquals(2, queue.dequeue(), "Dequeue should return 2");
        assertTrue(queue.isEmpty(), "Queue should be empty after dequeuing all elements");
    }

    @Test
    public void testPeek() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, queue.peek(), "Peek should return 1");
        assertFalse(queue.isEmpty(), "Queue should not be empty after peek");

        queue.dequeue();
        assertEquals(2, queue.peek(), "Peek should return 2 after dequeuing the first element");
    }

    @Test
    public void testDequeueEmptyException() {
        Queue<Integer> queue = new Queue<>();
        Exception exception = assertThrows(IllegalStateException.class, queue::dequeue, "Dequeue on empty queue should throw exception");
        assertEquals("Queue is empty", exception.getMessage());
    }

    @Test
    public void testPeekEmptyException() {
        Queue<Integer> queue = new Queue<>();
        Exception exception = assertThrows(IllegalStateException.class, queue::peek, "Peek on empty queue should throw exception");
        assertEquals("Queue is empty", exception.getMessage());
    }
}