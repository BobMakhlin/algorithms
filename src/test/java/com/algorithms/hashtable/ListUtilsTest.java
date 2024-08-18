package com.algorithms.hashtable;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ListUtilsTest {
    @Test
    public void testItemInCommon_withCommonItems() {
        List<Integer> list1 = List.of(1, 2, 3, 4);
        List<Integer> list2 = List.of(3, 5, 6, 7);

        boolean result = ListUtils.itemInCommon(list1, list2);

        assertTrue(result, "Lists share a common item (3)");
    }

    @Test
    public void testItemInCommon_withoutCommonItems() {
        List<Integer> list1 = List.of(1, 2, 3, 4);
        List<Integer> list2 = List.of(5, 6, 7, 8);

        boolean result = ListUtils.itemInCommon(list1, list2);

        assertFalse(result, "Lists do not share any common items");
    }

    @Test
    public void testItemInCommon_withEmptyFirstList() {
        List<Integer> list1 = List.of();
        List<Integer> list2 = List.of(1, 2, 3, 4);

        boolean result = ListUtils.itemInCommon(list1, list2);

        assertFalse(result, "First list is empty, so no common items possible");
    }

    @Test
    public void testItemInCommon_withEmptySecondList() {
        List<Integer> list1 = List.of(1, 2, 3, 4);
        List<Integer> list2 = List.of();

        boolean result = ListUtils.itemInCommon(list1, list2);

        assertFalse(result, "Second list is empty, so no common items possible");
    }

    @Test
    public void testItemInCommon_withBothListsEmpty() {
        List<Integer> list1 = List.of();
        List<Integer> list2 = List.of();

        boolean result = ListUtils.itemInCommon(list1, list2);

        assertFalse(result, "Both lists are empty, so no common items possible");
    }

    @Test
    public void testFindDupsWithDuplicates() {
        List<Integer> nums = Arrays.asList(4, 3, 2, 7, 8, 2, 3, 1);
        List<Integer> expected = Arrays.asList(2, 3);
        List<Integer> result = ListUtils.findDups(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testFindDupsWithoutDuplicates() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Collections.emptyList();
        List<Integer> result = ListUtils.findDups(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testFindDupsWithAllSameElements() {
        List<Integer> nums = Arrays.asList(3, 3, 3, 3, 3);
        List<Integer> expected = Collections.singletonList(3);
        List<Integer> result = ListUtils.findDups(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testFindDupsWithNegativeAndPositiveNumbers() {
        List<Integer> nums = Arrays.asList(-1, 0, 1, 0, -1, -1, 2, 2);
        List<Integer> expected = Arrays.asList(0, -1, 2);
        List<Integer> result = ListUtils.findDups(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testFindDupsWithEmptyList() {
        List<Integer> nums = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();
        List<Integer> result = ListUtils.findDups(nums);
        assertEquals(expected, result);
    }

    @Test
    public void testFirstNonRepeatingChar_Basic() {
        assertEquals('b', ListUtils.firstNonRepeatingChar("abacaad"));
    }

    @Test
    public void testFirstNonRepeatingChar_AllRepeating() {
        assertNull(ListUtils.firstNonRepeatingChar("aabbcc"));
    }

    @Test
    public void testFirstNonRepeatingChar_SingleCharacter() {
        assertEquals('a', ListUtils.firstNonRepeatingChar("a"));
    }

    @Test
    public void testFirstNonRepeatingChar_EmptyString() {
        assertNull(ListUtils.firstNonRepeatingChar(""));
    }

    @Test
    public void testFirstNonRepeatingChar_FirstCharNonRepeating() {
        assertEquals('m', ListUtils.firstNonRepeatingChar("morning"));
    }

    @Test
    public void testFirstNonRepeatingChar_LastCharNonRepeating() {
        assertEquals('g', ListUtils.firstNonRepeatingChar("aabbccg"));
    }

    @Test
    public void testFirstNonRepeatingChar_NonAlphabeticChars() {
        assertEquals('!', ListUtils.firstNonRepeatingChar("##$!%$$"));
    }

    @Test
    public void testGroupAnagrams() {
        List<String> input = List.of("eat", "tea", "tan", "ate", "nat", "bat");
        List<List<String>> expected = List.of(
                List.of("eat", "tea", "ate"),
                List.of("tan", "nat"),
                List.of("bat")
        );
        List<List<String>> result = ListUtils.groupAnagrams(input);

        // Convert lists to sets for comparison since order of groups and group elements doesn't matter
        assertEquals(expected.size(), result.size());
        assertEquals(expected.stream().map(Set::copyOf).collect(Collectors.toSet()),
                result.stream().map(Set::copyOf).collect(Collectors.toSet()));
    }

    @Test
    public void testGroupAnagrams_emptyInput() {
        List<String> input = List.of();
        List<List<String>> expected = List.of();
        List<List<String>> result = ListUtils.groupAnagrams(input);
        assertEquals(expected, result);
    }

    @Test
    public void testGroupAnagrams_singleString() {
        List<String> input = List.of("abc");
        List<List<String>> expected = List.of(List.of("abc"));
        List<List<String>> result = ListUtils.groupAnagrams(input);
        assertEquals(expected, result);
    }

    @Test
    public void testGroupAnagrams_noAnagrams() {
        List<String> input = List.of("abc", "def", "ghi");
        List<List<String>> expected = List.of(
                List.of("abc"),
                List.of("def"),
                List.of("ghi")
        );
        List<List<String>> result = ListUtils.groupAnagrams(input);
        assertEquals(expected.size(), result.size());
        assertEquals(expected.stream().map(Set::copyOf).collect(Collectors.toSet()),
                result.stream().map(Set::copyOf).collect(Collectors.toSet()));
    }

    @Test
    public void testGroupAnagrams_allAnagrams() {
        List<String> input = List.of("abc", "bca", "cab");
        List<List<String>> expected = List.of(List.of("abc", "bca", "cab"));
        List<List<String>> result = ListUtils.groupAnagrams(input);
        assertEquals(expected.size(), result.size());
        assertEquals(expected.stream().map(Set::copyOf).collect(Collectors.toSet()),
                result.stream().map(Set::copyOf).collect(Collectors.toSet()));
    }

    @Test
    public void testTwoSum_TargetExists() {
        List<Integer> list = List.of(2, 7, 11, 15);
        Integer target = 9;
        List<Integer> result = ListUtils.twoSum(list, target);
        assertEquals(2, result.size());
        assertEquals(0, result.get(0));
        assertEquals(1, result.get(1));
    }

    @Test
    public void testTwoSum_TargetDoesNotExist() {
        List<Integer> list = List.of(1, 2, 3, 4);
        Integer target = 10;
        List<Integer> result = ListUtils.twoSum(list, target);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testTwoSum_MultiplePairs() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Integer target = 7;
        List<Integer> result = ListUtils.twoSum(list, target);
        assertEquals(2, result.size());
        assertEquals(0, result.get(0));
        assertEquals(6 - 1, result.get(1)); // Expected index of 6 - 1 (last element)
    }

    @Test
    public void testTwoSum_NegativeNumbers() {
        List<Integer> list = List.of(-3, 4, 3, 90);
        Integer target = 0;
        List<Integer> result = ListUtils.twoSum(list, target);
        assertEquals(2, result.size());
        assertEquals(0, result.get(0));
        assertEquals(2, result.get(1));
    }

    @Test
    public void testTwoSum_EmptyList() {
        List<Integer> list = List.of();
        Integer target = 1;
        List<Integer> result = ListUtils.twoSum(list, target);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testTwoSum_SingleElement() {
        List<Integer> list = List.of(1);
        Integer target = 1;
        List<Integer> result = ListUtils.twoSum(list, target);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSubarraySumFoundAtBeginning() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Integer target = 6;
        List<Integer> result = ListUtils.subarraySum(nums, target);
        assertEquals(Arrays.asList(0, 2), result);
    }

    @Test
    public void testSubarraySumFoundAtMiddle() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Integer target = 9;
        List<Integer> result = ListUtils.subarraySum(nums, target);
        assertEquals(Arrays.asList(1, 3), result);
    }

    @Test
    public void testSubarraySumFoundAtEnd() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Integer target = 12;
        List<Integer> result = ListUtils.subarraySum(nums, target);
        assertEquals(Arrays.asList(2, 4), result);
    }

    @Test
    public void testSubarraySumSingleElement() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Integer target = 4;
        List<Integer> result = ListUtils.subarraySum(nums, target);
        assertEquals(Arrays.asList(3, 3), result);
    }

    @Test
    public void testSubarraySumNotFound() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Integer target = 20;
        List<Integer> result = ListUtils.subarraySum(nums, target);
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testSubarraySumEmptyList() {
        List<Integer> nums = Arrays.asList();
        Integer target = 5;
        List<Integer> result = ListUtils.subarraySum(nums, target);
        assertEquals(Arrays.asList(), result);
    }

    @Test
    void testRemoveDups_withDuplicates() {
        List<Integer> input = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, ListUtils.removeDups(input));
    }

    @Test
    void testRemoveDups_noDuplicates() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, ListUtils.removeDups(input));
    }

    @Test
    void testRemoveDups_emptyList() {
        List<Integer> input = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();
        assertEquals(expected, ListUtils.removeDups(input));
    }

    @Test
    void testRemoveDups_singleElement() {
        List<Integer> input = Collections.singletonList(1);
        List<Integer> expected = Collections.singletonList(1);
        assertEquals(expected, ListUtils.removeDups(input));
    }

    @Test
    void testRemoveDups_allDuplicates() {
        List<Integer> input = Arrays.asList(2, 2, 2, 2, 2);
        List<Integer> expected = Collections.singletonList(2);
        assertEquals(expected, ListUtils.removeDups(input));
    }

    @Test
    public void testEmptyString() {
        assertTrue(ListUtils.hasUniqueChars(""), "An empty string should return true.");
    }

    @Test
    public void testSingleCharacterString() {
        assertTrue(ListUtils.hasUniqueChars("a"), "A single character string should return true.");
    }

    @Test
    public void testUniqueChars() {
        assertTrue(ListUtils.hasUniqueChars("abcdef"), "A string with all unique characters should return true.");
    }

    @Test
    public void testNonUniqueChars() {
        assertFalse(ListUtils.hasUniqueChars("aabcdef"), "A string with repeated characters should return false.");
    }

    @Test
    public void testLongStringUniqueChars() {
        assertTrue(ListUtils.hasUniqueChars("abcdefghijklmnopqrstuvwxyz"), "A long string with unique characters should return true.");
    }

    @Test
    public void testLongStringNonUniqueChars() {
        assertFalse(ListUtils.hasUniqueChars("abcdefghijklmnaopqrstuvwxyz"), "A long string with one repeated character should return false.");
    }

    @Test
    public void testStringWithSpaces() {
        assertFalse(ListUtils.hasUniqueChars("ab cd ef gh  "), "A string with spaces and repeated characters should return false.");
    }

    @Test
    public void testStringWithSpecialChars() {
        assertTrue(ListUtils.hasUniqueChars("123!@#"), "A string with special characters and all unique should return true.");
        assertFalse(ListUtils.hasUniqueChars("123!@#3"), "A string with special characters and repeated ones should return false.");
    }

    @Test
    public void testFindPairs() {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = ListUtils.findPairs(arr1, arr2, target);

        // Expected output pairs
        int[][] expected = {{5, 2}, {3, 4}, {1, 6}};

        assertEquals(expected.length, pairs.size(), "Number of pairs doesn't match");

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], pairs.get(i), "Pair at index " + i + " doesn't match");
        }
    }

    @Test
    public void testFindPairsEmptyArrays() {
        int[] arr1 = {};
        int[] arr2 = {};
        int target = 5;

        List<int[]> pairs = ListUtils.findPairs(arr1, arr2, target);
        assertTrue(pairs.isEmpty(), "Pairs should be empty for empty input arrays");
    }

    @Test
    public void testFindPairsNoMatch() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {4, 5, 6};
        int target = 15;

        List<int[]> pairs = ListUtils.findPairs(arr1, arr2, target);
        assertTrue(pairs.isEmpty(), "Pairs should be empty when no pairs match the target sum");
    }

    @Test
    public void testFindPairsMultipleMatches() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3, 2, 1};
        int target = 4;

        List<int[]> pairs = ListUtils.findPairs(arr1, arr2, target);

        // Expected output pairs
        int[][] expected = {{1, 3}, {2, 2}, {3, 1}};

        assertEquals(expected.length, pairs.size(), "Number of pairs doesn't match");

        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], pairs.get(i), "Pair at index " + i + " doesn't match");
        }
    }

    @Test
    public void testLongestConsecutiveSequence() {
        // Test Case 1: Mixed numbers
        List<Integer> input1 = Arrays.asList(100, 4, 200, 1, 3, 2);
        assertEquals(4, ListUtils.longestConsecutiveSequence(input1), "Test Case 1 Failed");

        // Test Case 2: Consecutive sequence
        List<Integer> input2 = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(5, ListUtils.longestConsecutiveSequence(input2), "Test Case 2 Failed");

        // Test Case 3: Single pair of consecutive numbers
        List<Integer> input3 = Arrays.asList(10, 5, 6, 3, 4);
        assertEquals(4, ListUtils.longestConsecutiveSequence(input3), "Test Case 3 Failed");

        // Test Case 4: Single element
        List<Integer> input4 = Collections.singletonList(1);
        assertEquals(1, ListUtils.longestConsecutiveSequence(input4), "Test Case 4 Failed");

        // Test Case 5: Empty list
        List<Integer> input5 = Collections.emptyList();
        assertEquals(0, ListUtils.longestConsecutiveSequence(input5), "Test Case 5 Failed");

        // Test Case 6: Duplicates in the list
        List<Integer> input6 = Arrays.asList(1, 3, 2, 2, 4);
        assertEquals(4, ListUtils.longestConsecutiveSequence(input6), "Test Case 6 Failed");
    }
}