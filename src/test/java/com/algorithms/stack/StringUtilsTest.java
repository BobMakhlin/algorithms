package com.algorithms.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringUtilsTest {

    @Test
    public void testReverseString() {
        String input = "Hello, World!";
        String reversed = StringUtils.reverseString(input);
        assertEquals("!dlroW ,olleH", reversed);
    }

    @Test
    public void testEmptyString() {
        String input = "";
        String reversed = StringUtils.reverseString(input);
        assertEquals("", reversed);
    }

    @Test
    public void testSingleCharacterString() {
        String input = "H";
        String reversed = StringUtils.reverseString(input);
        assertEquals("H", reversed);
    }

    @Test
    public void testBalancedParentheses() {
        assertTrue(StringUtils.isBalancedParentheses("((()))"), "Failed on: ((()))");
        assertTrue(StringUtils.isBalancedParentheses("()()"), "Failed on: ()()");
        assertTrue(StringUtils.isBalancedParentheses("(())"), "Failed on: (())");
        assertTrue(StringUtils.isBalancedParentheses(""), "Failed on: empty string");
        assertTrue(StringUtils.isBalancedParentheses("()"), "Failed on: ()");
    }

    @Test
    public void testUnbalancedParentheses() {
        assertFalse(StringUtils.isBalancedParentheses("((())"), "Failed on: ((())");
        assertFalse(StringUtils.isBalancedParentheses("(()))"), "Failed on: (()))");
        assertFalse(StringUtils.isBalancedParentheses(")("), "Failed on: )(");
        assertFalse(StringUtils.isBalancedParentheses("((())()"), "Failed on: ((())()");
    }
}