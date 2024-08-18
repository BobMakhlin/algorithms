package com.algorithms.linkedlist;

public class BinaryUtils {
    private BinaryUtils() {
    }

    public static int binaryToDecimal(SinglyLinkedList<Integer> binaryList) {
        var c = binaryList.size() - 1;
        var sum = 0;
        for (var item : binaryList) {
            sum += (int) (item * Math.pow(2, c));
            c--;
        }
        return sum;
    }
}
