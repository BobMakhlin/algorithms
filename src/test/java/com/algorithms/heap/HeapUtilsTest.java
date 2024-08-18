package com.algorithms.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeapUtilsTest {
    @Test
    void shouldFindKthSmallestWithLargeInput() {
        int size = 1000000; // This can be the maximum limit of your input size
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = i + 1;
        }
        int k = size / 2;
        int expected = k;
        int actual = HeapUtils.findKthSmallest(nums, k);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldFindKthSmallestWithDuplicateNumbers() {
        int[] nums = {2, 1, 3, 2, 1, 3, 2, 1, 3};
        int k = 2;
        int expected = 1;
        int actual = HeapUtils.findKthSmallest(nums, k);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findKthSmallest_1() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int expected = 2;
        int actual = HeapUtils.findKthSmallest(nums, k);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findKthSmallest_2() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 1;
        int expected = 1;
        int actual = HeapUtils.findKthSmallest(nums, k);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findKthSmallest_3() {
        int[] nums = {-1, -2, -3, -5, -6, -4};
        int k = 3;
        int expected = -4;
        int actual = HeapUtils.findKthSmallest(nums, k);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findKthSmallest_4() {
        int[] nums = {-5, 3, 2, 1, -2, 0};
        int k = 4;
        int expected = 1;
        int actual = HeapUtils.findKthSmallest(nums, k);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findKthSmallest_5() {
        int[] nums = {0};
        int k = 1;
        int expected = 0;
        int actual = HeapUtils.findKthSmallest(nums, k);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testStreamMax() {
        int[] nums1 = {1, 5, 2, 9, 3, 6, 8};
        List<Integer> result1 = HeapUtils.streamMax(nums1);
        assertEquals(Arrays.asList(1, 5, 5, 9, 9, 9, 9), result1);

        int[] nums2 = {7, 2, 3, 1, 5};
        List<Integer> result2 = HeapUtils.streamMax(nums2);
        assertEquals(Arrays.asList(7, 7, 7, 7, 7), result2);

        int[] nums3 = {-1, -2, -3, -4, -5};
        List<Integer> result3 = HeapUtils.streamMax(nums3);
        assertEquals(Arrays.asList(-1, -1, -1, -1, -1), result3);

        // Testing with all numbers being the same
        int[] nums4 = {1, 1, 1, 1, 1, 1};
        List<Integer> result4 = HeapUtils.streamMax(nums4);
        assertEquals(Arrays.asList(1, 1, 1, 1, 1, 1), result4);

        // Testing with a reversed array
        int[] nums5 = {5, 4, 3, 2, 1};
        List<Integer> result5 = HeapUtils.streamMax(nums5);
        assertEquals(Arrays.asList(5, 5, 5, 5, 5), result5);

        // Testing with an empty array
        int[] nums6 = {};
        List<Integer> result6 = HeapUtils.streamMax(nums6);
        assertEquals(new ArrayList<>(), result6);
    }
}