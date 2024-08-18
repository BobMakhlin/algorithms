package com.algorithms.array;

import com.google.common.math.IntMath;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ArrayUtils {
    private ArrayUtils() {
    }

    public static int maxSubarray(int[] nums) {
        // time complexity O(N)
        // space complexity O(N)

        var cumulativeSums = new ArrayList<Integer>();
        var sum = 0;
        var maxCumulativeSumIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            cumulativeSums.add(sum);
            if (sum > nums[maxCumulativeSumIndex]) {
                maxCumulativeSumIndex = i;
            }
        }
        final var maxCumulativeSum = cumulativeSums.get(maxCumulativeSumIndex);
        var maxSubarraySum = cumulativeSums.get(maxCumulativeSumIndex);

        for (var i = 0; i <= maxCumulativeSumIndex - 1; i++) {
            var difference = maxCumulativeSum - cumulativeSums.get(i);
            if (difference > maxSubarraySum) {
                maxSubarraySum = difference;
            }
        }
        return maxSubarraySum;
    }

    public static int maxSubarrayKadaneAlgo(int[] nums) {
        // time complexity O(N)
        // space complexity O(1)

        if (nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static int removeDuplicatesInSortedArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        var newLength = 1;
        var offset = 0;
        for (var i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[i - offset] = nums[i];
                newLength++;
            } else {
                offset++;
            }
        }
        return newLength;
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        var minPrice = prices[0];
        var maxProfit = 0;
        for (var i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    // space complexity O(N), time complexity O(N)..   :(
    // the worst version :(
    public static <T> void rotateV1(List<T> arr, int k) {
        k = k % arr.size();
        if (k == arr.size() || arr.size() < 2 || k < 1) {
            return;
        }
        var visitedIndexes = new HashSet<Integer>();

        var rotationsCount = 0;
        var currentPosition = 0;
        var currentValue = arr.get(0);
        while (rotationsCount < k) {
            var newPosition = currentPosition + k;
            var newPositionInArray = newPosition % arr.size();
            var previousValue = arr.get(newPositionInArray);

            if (visitedIndexes.contains(currentPosition)) {
                currentPosition++;
                currentValue = arr.get(currentPosition);
            } else {
                arr.set(newPositionInArray, currentValue);
                if (newPosition >= arr.size()) {
                    rotationsCount++;
                }
                visitedIndexes.add(currentPosition);
                currentPosition = newPositionInArray;
                currentValue = previousValue;
            }
        }
    }

    // space complexity O(1), time complexity O(N)..   :)
    public static <T> void rotateV2(List<T> arr, int k) {
        if (k == arr.size() || arr.size() < 2 || k < 1) {
            return;
        }
        k = k % arr.size();

        // In order to avoid remembering visited indexes, we use GCD.
        // GCD specifies the count of "sets" the array is split by the K.
        var gcd = IntMath.gcd(arr.size(), k);
        var rotationsCount = 0;

        for (var i = 0; i < gcd; i++) {
            var currentPosition = i;
            var currentValue = arr.get(i);

            do {
                var newPosition = currentPosition + k;
                var newPositionInArray = newPosition % arr.size();
                var previousValue = arr.get(newPositionInArray);

                arr.set(newPositionInArray, currentValue);
                if (newPosition >= arr.size()) {
                    rotationsCount++;
                }
                currentPosition = newPositionInArray;
                currentValue = previousValue;
            } while (rotationsCount < k && currentPosition != i);
            // If we return to the same position in the array,
            // just proceed with the next item.
        }
    }

    // classic solution
    // O(1) space, O(N) time.
    public static void rotateV3(int[] nums, int k) {
        k = k % nums.length;

        // Reverse the first part
        for (int start = 0, end = nums.length - k - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        // Reverse the second part
        for (int start = nums.length - k, end = nums.length - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        // Reverse the whole array
        for (int start = 0, end = nums.length - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }


    // space complexity O(1)
    public static int removeElement(int[] nums, int val) {
        var targetCount = 0;
        for (var i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                targetCount++;
            } else {
                nums[i - targetCount] = nums[i];
            }
        }
        return nums.length - targetCount;
    }

    public static int[] findMaxMin(int[] array) {
        if (array.length == 0) {
            return new int[0];
        }
        if (array.length == 1) {
            return new int[]{array[0], array[0]};
        }
        var max = array[0];
        var min = array[0];

        for (var i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            } else if (array[i] < min) {
                min = array[i];
            }
        }
        return new int[]{max, min};
    }

    public static String findLongestString(String[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        if (array.length == 1) {
            return array[0];
        }
        var longest = array[0];
        for (var i = 1; i < array.length; i++) {
            if (array[i].length() > longest.length()) {
                longest = array[i];
            }
        }
        return longest;
    }
}
