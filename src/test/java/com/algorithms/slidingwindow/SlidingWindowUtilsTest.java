package com.algorithms.slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.algorithms.slidingwindow.SlidingWindowUtils.findMaxInSlidingWindows;

class SlidingWindowUtilsTest {
    @Test
    void shouldFindMaximums() {
        var actual1 = findMaxInSlidingWindows(List.of(1, 3, -1, -3, 5, 3, 6, 7), 3);
        Assertions.assertEquals(List.of(3, 3, 5, 5, 6, 7), actual1);

        var actual2 = findMaxInSlidingWindows(List.of(-1, 3, 1, -3, -5, 3, 6, 7), 3);
        Assertions.assertEquals(List.of(3, 3, 1, 3, 6, 7), actual2);

        var actual3 = findMaxInSlidingWindows(List.of(4, 4, 1, 3, -5, 3, 6, 7), 3);
        Assertions.assertEquals(List.of(4, 4, 3, 3, 6, 7), actual3);
    }

}