package com.algorithms.slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://leetcode.com/problems/sliding-window-maximum/description/
public final class SlidingWindowUtils {
    private SlidingWindowUtils() {
    }

    public static List<Integer> findMaxInSlidingWindows(List<Integer> numbers, int windowSize) {
        if (windowSize > numbers.size()) {
            throw new IllegalArgumentException("Window size cannot be greater than the size of the array");
        }
        if (numbers.isEmpty()) {
            return List.of();
        }

        var maximums = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<>();


        // Process the first window.
        for (var i = 0; i < windowSize; i++) {
            insertCurrentNumberIntoDeque(deque, numbers.get(i));
        }
        maximums.add(getMaximum(deque));


        // Process the other windows.
        var windowStart = 0;
        var windowEnd = windowSize;


        while (windowEnd < numbers.size()) {
            // Remove the item that's out of the current window.
            if (numbers.get(windowStart).equals(deque.peekFirst())) {
                deque.removeFirst();
            }
            var newItem = numbers.get(windowEnd);
            insertCurrentNumberIntoDeque(deque, newItem);
            maximums.add(getMaximum(deque));


            windowStart++;
            windowEnd++;
        }

        return maximums;
    }


    private static void insertCurrentNumberIntoDeque(Deque<Integer> deque, Integer currentNumber) {
        // Get rid of the items that are never going to be maximums in the future windows.
        // (they will never become maximums in the same window with the current number,
        // the current number will live longer than them since it's inserted later).
        while (deque.peekLast() != null && deque.peekLast() < currentNumber) {
            deque.removeLast();
        }
        // Either the current number becomes a new maximum (if the deque is empty),
        // or the current maximum remains in the deque and the current number is added
        // because it might become a maximum in future windows.
        deque.addLast(currentNumber);
    }

    private static Integer getMaximum(Deque<Integer> deque) {
        return deque.peekFirst();
    }
}
