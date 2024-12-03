package com.algorithms.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubarraySumProblemTest {
    @Test
    void test() {
        var subarraySumProblem = new SubarraySumProblem();
        var result = subarraySumProblem.subarraySum(new int[]{0, 0, 6, 12}, 6);
        Assertions.assertEquals(3, result);
    }
}