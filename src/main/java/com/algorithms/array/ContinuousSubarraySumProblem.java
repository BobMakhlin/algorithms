package com.algorithms.array;

import java.util.HashMap;

// https://leetcode.com/problems/continuous-subarray-sum/description/
public class ContinuousSubarraySumProblem {
    private static final int MIN_SUBARRAY_LENGTH = 2;

    public boolean checkSubarraySum(int[] nums, int k) {
        // j>i
        // if Sj % K == Si % K, then
        // between j and i there's a subarray that is % K == 0
        // e.g., [23, 4, 5, 3, 10, 11], K = 6
        // 23%6=5  i=0
        // 27%6=3
        // 32%6=2
        // 35%6=5  j=3
        // So, between i and j we added 12. (4+5+3=12)
        // j-i>=2 (!)


        var currentSum= 0;
        var indexBySumRemainder = new HashMap<Integer, Integer>();

        for (var j = 0; j < nums.length; j++) {
            var num = nums[j];
            currentSum += num;
            var remainder = currentSum % k;

            var indexOfPrevSum = indexBySumRemainder.get(remainder);

            if (indexOfPrevSum == null) {
                indexBySumRemainder.put(remainder, j);
                continue;
            }
            if (j - indexOfPrevSum >= MIN_SUBARRAY_LENGTH) {
                return true;
            }
        }

        return false;
    }

}
