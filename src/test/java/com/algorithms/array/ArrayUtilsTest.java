package com.algorithms.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.algorithms.array.ArrayUtils.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayUtilsTest {
    @Test
    public void testRemoveElement() {
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int value = 1;

        int newLength = ArrayUtils.removeElement(array, value);

        assertEquals(7, newLength);

        int[] expectedArray = {-2, -3, 4, -1, 2, -5, 4, -5, 4};

        for (int i = 0; i < newLength; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }

    @Test
    public void testRemoveElementWithEmptyArray() {
        int[] array = {};
        int value = 1;

        int newLength = ArrayUtils.removeElement(array, value);

        assertEquals(0, newLength);
    }

    @Test
    public void testRemoveElementWithNoValueToRemove() {
        int[] array = {2, 3, 4};
        int value = 1;

        int newLength = ArrayUtils.removeElement(array, value);

        assertEquals(3, newLength);

        int[] expectedArray = {2, 3, 4};

        for (int i = 0; i < newLength; i++) {
            assertEquals(expectedArray[i], array[i]);
        }
    }

    @Test
    public void testFindMaxMinDoesNotThrowExceptionOnEmptyArray() {
        int[] nums = {};
        int[] expected = new int[0];
        assertArrayEquals(expected, ArrayUtils.findMaxMin(nums));
    }

    @Test
    public void testFindMaxMinReturnsCorrectResultOnPositiveNumbers() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {5, 1};
        assertArrayEquals(expected, ArrayUtils.findMaxMin(nums));
    }

    @Test
    public void testFindMaxMinReturnsCorrectResultOnNegativeNumbers() {
        int[] nums = {-5, -4, -3, -2, -1};
        int[] expected = {-1, -5};
        assertArrayEquals(expected, ArrayUtils.findMaxMin(nums));
    }

    @Test
    public void testFindMaxMinReturnsCorrectResultOnMixedPositiveAndNegativeNumbers() {
        int[] nums = {5, -4, 3, -2, -1};
        int[] expected = {5, -4};
        assertArrayEquals(expected, ArrayUtils.findMaxMin(nums));
    }

    @Test
    public void testFindLongestString() {
        String[] array1 = {"Java", "Python", "C++", "JavaScript"};
        Assertions.assertEquals("JavaScript", ArrayUtils.findLongestString(array1));

        String[] array2 = {"", "a", "ab", "abc"};
        Assertions.assertEquals("abc", ArrayUtils.findLongestString(array2));

        String[] array3 = {"abcd", "ab", "abc", "a"};
        Assertions.assertEquals("abcd", ArrayUtils.findLongestString(array3));

        String[] array4 = {};
        Assertions.assertNull(ArrayUtils.findLongestString(array4));

        String[] array5 = null;
        Assertions.assertNull(ArrayUtils.findLongestString(array5));
    }

    @Test
    public void testmaxSubarrayKadaneAlgo() {
        // Testing with a positive case
        int[] nums1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected1 = 6; // subarray with maximum sum is {4, -1, 2, 1}
        assertEquals(expected1, maxSubarrayKadaneAlgo(nums1));

        // Testing with an array that includes only one element
        int[] nums2 = new int[]{1};
        int expected2 = 1;
        assertEquals(expected2, maxSubarrayKadaneAlgo(nums2));

        // Testing with an all-negative array
        int[] nums3 = new int[]{-2, -3, -4};
        int expected3 = -2; // max subarray is {-2}
        assertEquals(expected3, maxSubarrayKadaneAlgo(nums3));

        // Testing with an all-positive array
        int[] nums4 = new int[]{1, 2, 3, 4, 5};
        int expected4 = 15; // max subarray is {1, 2, 3, 4, 5}
        assertEquals(expected4, maxSubarrayKadaneAlgo(nums4));

        // Testing with an array that includes multiple equal elements
        int[] nums5 = new int[]{1, 1, 1, 1, 1, 1, 1};
        int expected5 = 7; // max subarray is {1, 1, 1, 1, 1, 1, 1}
        assertEquals(expected5, maxSubarrayKadaneAlgo(nums5));

        // Testing with an all-positive array
        int[] nums6 = new int[]{-100, 100, 200, -100};
        int expected6 = 300; // max subarray is {1, 2, 3, 4, 5}
        assertEquals(expected6, maxSubarrayKadaneAlgo(nums6));

        // Testing with an all-positive array
        int[] nums7 = new int[]{-100, -100, -100, -100, -100, 1000, -100};
        int expected7 = 1000; // max subarray is {1, 2, 3, 4, 5}
        assertEquals(expected7, maxSubarrayKadaneAlgo(nums7));
    }


    @Test
    public void testRemoveDuplicatesInSortedArray_UniqueElements() {
        int[] nums = {1, 2, 3, 4, 5};
        int newLength = ArrayUtils.removeDuplicatesInSortedArray(nums);
        assertEquals(5, newLength);
    }

    @Test
    public void testRemoveDuplicatesInSortedArray_DuplicateElements() {
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int newLength = ArrayUtils.removeDuplicatesInSortedArray(nums);
        assertEquals(5, newLength);
    }

    @Test
    public void testRemoveDuplicatesInSortedArray_EmptyArray() {
        int[] nums = {};
        int newLength = ArrayUtils.removeDuplicatesInSortedArray(nums);
        assertEquals(0, newLength);
    }

    @Test
    public void testMaxProfitNormalCase() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(prices);
        Assertions.assertEquals(5, maxProfit);
    }

    @Test
    public void testMaxProfitAllIdentical() {
        int[] prices = {2, 2, 2, 2, 2};
        int maxProfit = maxProfit(prices);
        Assertions.assertEquals(0, maxProfit);
    }

    @Test
    public void testMaxProfitDecreasing() {
        int[] prices = {5, 4, 3, 2, 1};
        int maxProfit = maxProfit(prices);
        Assertions.assertEquals(0, maxProfit);
    }

    @Test
    public void testMaxProfitIncreasing() {
        int[] prices = {1, 2, 3, 4, 10, 1, 1, 1, 3};
        int maxProfit = maxProfit(prices);
        Assertions.assertEquals(9, maxProfit);
    }

    @Test
    public void testMaxProfitEmpty() {
        int[] prices = {};
        int maxProfit = maxProfit(prices);
        Assertions.assertEquals(0, maxProfit);
    }

    @Nested
    class RotateV2 {
        @Test
        public void testRotate() {

            rotateV3(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 3);

            List<Integer> nums0 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
            int k0 = 6;
            rotateV2(nums0, k0);
            Assertions.assertArrayEquals(new Integer[]{3, 4, 5, 6, 7, 8, 1, 2}, nums0.toArray());

            List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
            int k1 = 3;
            rotateV2(nums1, k1);
            Assertions.assertArrayEquals(new Integer[]{5, 6, 7, 1, 2, 3, 4}, nums1.toArray());

            List<Integer> nums2 = Arrays.asList(-1, -100, 3, 99);
            int k2 = 2;
            rotateV2(nums2, k2);
            Assertions.assertArrayEquals(new Integer[]{3, 99, -1, -100}, nums2.toArray());

            List<Integer> nums3 = Arrays.asList(1, 2);
            int k3 = 3;
            rotateV2(nums3, k3);
            Assertions.assertArrayEquals(new Integer[]{2, 1}, nums3.toArray());

            List<Integer> nums4 = Arrays.asList(1, 2, 3, 4, 5);
            int k4 = 0;
            rotateV2(nums4, k4);
            Assertions.assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, nums4.toArray());
        }

        @Test
        public void testRotateV2_WithDuplicates() {
            // Preparation
            var original = Arrays.asList(1, 2, 3, 1, 2, 3, 1, 2);
            var expected = Arrays.asList(3, 1, 2, 1, 2, 3, 1, 2);

            //Testing
            ArrayUtils.rotateV2(original, 3);
            assertEquals(expected, original);

            original = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1);
            expected = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1);
            ArrayUtils.rotateV2(original, 3);
            assertEquals(expected, original);

            original = Arrays.asList(1, 2, 2, 2, 1, 2, 2, 2);
            expected = Arrays.asList(2, 2, 1, 2, 2, 2, 1, 2);
            ArrayUtils.rotateV2(original, 2);
            assertEquals(expected, original);

            original = Arrays.asList(1, 1, 2, 2, 1, 1, 2, 2);
            expected = Arrays.asList(1, 2, 2, 1, 1, 2, 2, 1);
            ArrayUtils.rotateV2(original, 3);
            assertEquals(expected, original);
        }

        @Test
        public void testRotateV2_RotateCountGreaterThanArrayLength() {
            List<Integer> original = Arrays.asList(1, 2, 3, 4);
            List<Integer> expected = Arrays.asList(4, 1, 2, 3);

            ArrayUtils.rotateV2(original, 5);
            assertEquals(expected, original);
        }

        @Test
        public void testRotateV2_RotateCountEqualToZero() {
            List<Integer> original = Arrays.asList(1, 2, 3, 4);
            List<Integer> expected = Arrays.asList(1, 2, 3, 4);

            ArrayUtils.rotateV2(original, 0);
            assertEquals(expected, original);
        }

        @Test
        public void testRotateV2_SingleElementArray() {
            List<Integer> original = Arrays.asList(4);
            List<Integer> expected = Arrays.asList(4);

            ArrayUtils.rotateV2(original, 5);
            assertEquals(expected, original);
        }

        @Test
        public void testRotateV2_EmptyArray() {
            List<Integer> original = Arrays.asList();
            List<Integer> expected = Arrays.asList();

            ArrayUtils.rotateV2(original, 5);
            assertEquals(expected, original);
        }
    }
}