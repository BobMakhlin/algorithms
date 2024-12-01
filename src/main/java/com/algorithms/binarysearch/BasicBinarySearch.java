package com.algorithms.binarysearch;

public class BasicBinarySearch {
    public boolean contains(int[] array, int value) {
        var left = 0;
        var right = array.length - 1;

        while (left <= right) {
            var middle = (left + right) / 2;

            if (array[middle] == value) {
                return true;
            }

            if (array[middle] < value) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return false;
    }
}
