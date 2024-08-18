package com.algorithms.hashtable;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test
    void testSetAndGet() {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.set("one", 1);
        hashTable.set("two", 2);
        hashTable.set("three", 3);

        assertEquals(1, hashTable.get("one"));
        assertEquals(2, hashTable.get("two"));
        assertEquals(3, hashTable.get("three"));
        assertNull(hashTable.get("four"));
    }

    @Test
    void testKeys() {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.set("one", 1);
        hashTable.set("two", 2);
        hashTable.set("three", 3);

        List<String> keys = hashTable.keys();
        assertTrue(keys.contains("one"));
        assertTrue(keys.contains("two"));
        assertTrue(keys.contains("three"));
        assertEquals(3, keys.size());
    }

    @Test
    void testRemove() {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.set("one", 1);
        hashTable.set("two", 2);
        hashTable.set("three", 3);

        assertEquals(1, hashTable.get("one"));
        assertEquals(2, hashTable.get("two"));
        assertEquals(3, hashTable.get("three"));

        hashTable.remove("two");
        assertNull(hashTable.get("two"));
        assertEquals(1, hashTable.get("one"));
        assertEquals(3, hashTable.get("three"));

        hashTable.remove("one");
        assertNull(hashTable.get("one"));
        assertEquals(3, hashTable.get("three"));

        hashTable.remove("three");
        assertNull(hashTable.get("three"));
    }

    @Test
    public void testSetAndResize() {
        // Given a hash table with a small initial capacity to easily trigger a resize
        HashTable<Integer, String> hashTable = new HashTable<>(4, 0.75f);

        assertEquals(4, hashTable.getCapacity(), "Initial capacity should be 4");

        // Insert elements to trigger a resize when the load factor threshold is reached
        hashTable.set(1, "one");
        hashTable.set(2, "two");

        // Assert that capacity is still 4 (resize should not happen yet)
        assertEquals(4, hashTable.getCapacity(), "Capacity should still be 4 before reaching the threshold");

        // Inserting another element should now trigger resize (since size will be 3 and threshold is 4 * 0.75 = 3)
        hashTable.set(3, "three");

        // Verify that resize occurred and capacity doubled
        assertEquals(8, hashTable.getCapacity(), "Capacity should be 8 after resize");

        // Verify that all values are still accessible after resize
        assertAll(
                () -> assertEquals("one", hashTable.get(1)),
                () -> assertEquals("two", hashTable.get(2)),
                () -> assertEquals("three", hashTable.get(3))
        );

        // Insert one more element to verify continued functionality
        hashTable.set(4, "four");
        assertEquals("four", hashTable.get(4));
    }

    @Test
    public void testSetAndOverwrite() {
        // Given a hash table
        HashTable<String, String> hashTable = new HashTable<>();

        // Add an element
        hashTable.set("key", "value1");
        assertEquals("value1", hashTable.get("key"));

        // Overwrite the element with the same key
        hashTable.set("key", "value2");
        assertEquals("value2", hashTable.get("key"));

        // Verify that the size is still 1
        assertEquals(1, hashTable.getSize());
    }

    @Test
    public void testResizeMaintainsElements() {
        // Given a hash table with a small initial capacity
        HashTable<Integer, String> hashTable = new HashTable<>(2, 0.75f);

        // Insert elements to trigger resize
        hashTable.set(1, "one");

        // Trigger resize
        hashTable.set(2, "two");
        assertEquals(4, hashTable.getCapacity(), "Capacity should be 4 after resize");

        // Verify that all elements are still accessible after resize
        assertEquals("one", hashTable.get(1));
        assertEquals("two", hashTable.get(2));
    }

    @Test
    public void testShrink() {
        HashTable<Integer, String> hashTable = new HashTable<>();
        int initialCapacity = hashTable.getCapacity();

        // Insert elements to trigger resize
        for (int i = 0; i < initialCapacity; i++) {
            hashTable.set(i, "val" + i);
        }
        // Remove elements to trigger shrinking
        for (int i = 0; i < initialCapacity; i++) {
            hashTable.remove(i);
        }

        assertTrue(hashTable.getCapacity() < initialCapacity, "Capacity should have decreased after shrinking");
    }

    @Test
    public void testShrinkAndRetrieve() {
        HashTable<Integer, String> hashTable = new HashTable<>();
        int initialCapacity = hashTable.getCapacity();

        // Insert elements to trigger resize
        for (int i = 0; i < initialCapacity; i++) {
            hashTable.set(i, "val" + i);
        }
        // Remove elements to trigger shrinking
        for (int i = 0; i < initialCapacity; i++) {
            hashTable.remove(i);
        }

        // Verify elements are null after removal
        for (int i = 0; i < initialCapacity; i++) {
            assertNull(hashTable.get(i));
        }
    }
}