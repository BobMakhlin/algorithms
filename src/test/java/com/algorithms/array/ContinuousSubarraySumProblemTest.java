package com.algorithms.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContinuousSubarraySumProblemTest {
    @Test
    void shouldReturnTrue() {
        Assertions.assertTrue(new ContinuousSubarraySumProblem().checkSubarraySum(new int[]{23, 4, 5, 3, 10, 11}, 6));
    }

    @Test
    void shouldReturnFalse() {
        Assertions.assertFalse(new ContinuousSubarraySumProblem().checkSubarraySum(new int[]{23, 2, 111}, 6));
    }
}