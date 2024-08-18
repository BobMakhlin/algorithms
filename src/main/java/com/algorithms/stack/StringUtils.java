package com.algorithms.stack;

public class StringUtils {
    private StringUtils() {
    }

    private static final char OPEN_PARENTHESIS = '(';
    private static final char CLOSE_PARENTHESIS = ')';

    public static boolean isBalancedParentheses(String str) {
        var stack = new Stack<Character>();
        for (var c : str.toCharArray()) {
            if (c == OPEN_PARENTHESIS) {
                stack.push(c);
            } else if (c == CLOSE_PARENTHESIS) {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static String reverseString(String str) {
        var stack = new Stack<Character>();
        for (var c : str.toCharArray()) {
            stack.push(c);
        }
        var reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
}
