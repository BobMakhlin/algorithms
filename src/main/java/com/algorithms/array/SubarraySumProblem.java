package com.algorithms.array;

import java.util.HashMap;

public class SubarraySumProblem {
    public int subarraySum(int[] nums, int k) {
        var countBySum = new HashMap<Integer, Integer>();
        var subarraysCount = 0;
        var sum = 0;
        countBySum.put(0, 1);

        for (var num : nums) {
            sum += num;

            // Check if there's a prefix sum that "spoil" the current sum.
            var difference = sum - k;
            if (countBySum.containsKey(difference)) {
                subarraysCount += countBySum.get(difference);
            }

            // specially for cases like [0,0,6] k = 6 where the output should be 3! (since there are 3 subarrays summing up to 6).
            var count = countBySum.get(sum);
            var newCount = count == null ? 1 : count + 1;
            countBySum.put(sum, newCount);
        }

        return subarraysCount;
    }
}
