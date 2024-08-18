package com.algorithms.sorting;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortingUtilsTest {
    @Test
    void testBubbleSort() {
        int[] array = {5, 9, 3, 1, 2};
        int[] expected = {1, 2, 3, 5, 9};
        SortingUtils.bubbleSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testSelectionSort() {
        int[] array = {5, 9, 3, 1, 2};
        int[] expected = {1, 2, 3, 5, 9};
        SortingUtils.selectionSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testInsertionSort() {
        int[] array = {100, 12, 9, 11, 14, 3, 2, 1, 4, 5};
        int[] expected = {1, 2, 3, 4, 5, 9, 11, 12, 14, 100};
        SortingUtils.insertionSort(array);
        assertArrayEquals(expected, array);
    }

    @Test
    void testMergeSort_With_Unsorted_List() {
        // Arrange
        List<Integer> unsortedList = Arrays.asList(5, 1, 6, 2, 4, 3);
        List<Integer> expectedResult = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Act
        List<Integer> result = SortingUtils.mergeSort(unsortedList);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testMergeSort_With_Empty_List() {
        // Arrange
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> expectedResult = new ArrayList<>();

        // Act
        List<Integer> result = SortingUtils.mergeSort(emptyList);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void testMergeSort_With_Single_Element_List() {
        // Arrange
        List<Integer> singleElementList = Collections.singletonList(1);
        List<Integer> expectedResult = Collections.singletonList(1);

        // Act
        List<Integer> result = SortingUtils.mergeSort(singleElementList);

        // Assert
        assertEquals(expectedResult, result);
    }
}