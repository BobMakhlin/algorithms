package com.algorithms.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthOfLongestSubstringProblemTest {
    @Test
    void shouldFindLength() {
        assertEquals(3, new LengthOfLongestSubstringProblem().lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, new LengthOfLongestSubstringProblem().lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, new LengthOfLongestSubstringProblem().lengthOfLongestSubstring("pwwkew"));
        assertEquals(7, new LengthOfLongestSubstringProblem().lengthOfLongestSubstring("andvxdryuo"));
    }
}