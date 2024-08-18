package com.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class SortingUtils {
    private SortingUtils() {}

    public static void bubbleSort(final int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(final int[] array) {
        for (var i = 0; i < array.length; i++) {
            var minIndex = i;
            for (var j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
    }

    public static void insertionSort(final int[] array) {
        for (int i = 1; i < array.length; i++) {
            var j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(array, j, j - 1);
                j--;
            }
        }
    }

    public static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }
        return mergeSortRecursive(list);
    }

    private static List<Integer> mergeSortRecursive(List<Integer> list) {
        if (list.size() == 1) {
            return list;
        }
        var middleIndex = list.size() / 2;
        var left = list.subList(0, middleIndex);
        var right = list.subList(middleIndex, list.size());
        var sortedLeft = mergeSortRecursive(left);
        var sortedRight = mergeSortRecursive(right);
        return mergeLists(sortedLeft, sortedRight);
    }

    private static List<Integer> mergeLists(List<Integer> l1, List<Integer> l2) {
        var i = 0;
        var j = 0;
        var newList = new ArrayList<Integer>();
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) <= l2.get(j)) {
                newList.add(l1.get(i));
                i++;
            } else {
                newList.add(l2.get(j));
                j++;
            }
        }
        if (i < l1.size()) {
            newList.addAll(l1.subList(i, l1.size()));
        }
        if (j < l2.size()) {
            newList.addAll(l2.subList(j, l2.size()));
        }
        return newList;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
