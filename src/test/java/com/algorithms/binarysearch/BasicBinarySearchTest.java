package com.algorithms.binarysearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasicBinarySearchTest {
    @Test
    void shouldCheckIfContains() {
        var arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Assertions.assertTrue(new BasicBinarySearch().contains(arr, 1));
        Assertions.assertTrue(new BasicBinarySearch().contains(arr, 2));
        Assertions.assertTrue(new BasicBinarySearch().contains(arr, 3));
        Assertions.assertTrue(new BasicBinarySearch().contains(arr, 4));
        Assertions.assertTrue(new BasicBinarySearch().contains(arr, 5));
        Assertions.assertTrue(new BasicBinarySearch().contains(arr, 6));
        Assertions.assertTrue(new BasicBinarySearch().contains(arr, 7));
        Assertions.assertTrue(new BasicBinarySearch().contains(arr, 8));
        Assertions.assertTrue(new BasicBinarySearch().contains(arr, 9));
        Assertions.assertTrue(new BasicBinarySearch().contains(arr, 10));
        Assertions.assertTrue(new BasicBinarySearch().contains(arr, 11));
    }

    @Test
    void shouldCheckIfNotContains() {
        Assertions.assertFalse(new BasicBinarySearch().contains(new int[]{1, 2, 3, 4, 5, 6}, 111));
    }
}