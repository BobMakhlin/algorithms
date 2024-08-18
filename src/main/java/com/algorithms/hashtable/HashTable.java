package com.algorithms.hashtable;

import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable<K, E> {
    private final static float DEFAULT_LOAD_FACTOR = 0.75f;
    private final static int DEFAULT_INITIAL_CAPACITY = 16;
    private final static float DEFAULT_SHRINK_FACTOR = 0.15f;

    private ArrayList<LinkedList<Entry>> table;
    @Getter
    private int size;
    @Getter
    private int capacity;
    private final float loadFactor;
    private final float shrinkFactor;

    public HashTable() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR, DEFAULT_SHRINK_FACTOR);
    }

    public HashTable(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, DEFAULT_SHRINK_FACTOR);
    }

    public HashTable(int initialCapacity, float loadFactor, float shrinkFactor) {
        this.capacity = initialCapacity;
        this.loadFactor = loadFactor;
        this.shrinkFactor = shrinkFactor;
        this.table = new ArrayList<>(capacity);
        for (var i = 0; i < initialCapacity; i++) {
            table.add(null);
        }
    }

    public void set(K key, E val) {
        var bucket = getBucketOrCreateNew(key, table);
        var existingEntry = findEntryInBucket(key, bucket);
        if (existingEntry != null) {
            existingEntry.val = val;
            return;
        }
        bucket.add(new Entry(key, val));
        size++;
        if (size >= getResizeThreshold()) {
            resize(false);
        }
    }

    public E get(K key) {
        var bucket = table.get(getHash(key));
        if (bucket == null) {
            return null;
        }
        var e = findEntryInBucket(key, bucket);
        return e != null ? e.val : null;
    }

    public boolean remove(K key) {
        var h = getHash(key);
        var bucket = table.get(h);
        if (bucket == null) {
            return false;
        }

        if (bucket.size() == 1) {
            table.set(h, null);
        } else if (!bucket.removeIf(e -> e.key.equals(key))) {
            return false;
        }
        size--;
        if (size <= getShrinkThreshold()) {
            resize(true);
        }
        return true;
    }

    public List<K> keys() {
        var k = new ArrayList<K>();
        for (var bucket : table) {
            if (bucket == null) {
                continue;
            }
            for (var entry : bucket) {
                k.add(entry.key);
            }
        }
        return k;
    }

    private int getHash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) // Non-negative hash.
                % capacity;
    }

    private int getShrinkThreshold() {
        return (int) (capacity * shrinkFactor);
    }

    private int getResizeThreshold() {
        return (int) (capacity * loadFactor);
    }

    private void resize(boolean isShrinking) {
        capacity = isShrinking ? capacity / 2 : capacity * 2;
        var newBuckets = new ArrayList<LinkedList<Entry>>(capacity);
        for (var i = 0; i < capacity; i++) {
            newBuckets.add(null);
        }
        // Recalculate hashes.
        for (var bucket : this.table) {
            if (bucket == null) {
                continue;
            }
            for (var entry : bucket) {
                var b = getBucketOrCreateNew(entry.key, newBuckets);
                b.add(entry);
            }
        }
        this.table = newBuckets;
    }

    private LinkedList<Entry> getBucketOrCreateNew(K key, ArrayList<LinkedList<Entry>> table) {
        var h = getHash(key);
        var bucket = table.get(h);
        if (bucket == null) {
            bucket = new LinkedList<>();
            table.set(h, bucket);
        }
        return bucket;
    }

    private Entry findEntryInBucket(K key, LinkedList<Entry> bucket) {
        for (var entry : bucket) {
            if (entry.key.equals(key)) {
                return entry;
            }
        }
        return null;
    }

    private class Entry {
        K key;
        E val;

        public Entry(K key, E val) {
            this.key = key;
            this.val = val;
        }
    }
}
