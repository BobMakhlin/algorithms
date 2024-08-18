package com.algorithms.dynamicprogramming;

import java.util.HashMap;

public class Math {
    private HashMap<Integer, Integer> fibonacciCache = new HashMap<>();
    private int counter;

    // O(2^N) !!!!!
    public int fibonacci(int n) {
        counter++;

        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // just O(N) :)
    // .... O(2N - 1) simplified to O(N)
    public int fibonacciOptimized(int n) {
        counter++;

        if (n == 0 || n == 1) {
            return n;
        }

        var cachedVal = fibonacciCache.get(n);
        if (cachedVal != null) {
            return cachedVal;
        }

        var res = fibonacciOptimized(n - 1) + fibonacciOptimized(n - 2);
        fibonacciCache.putIfAbsent(n, res);
        return res;
    }

    public int getCallsCount() {
        return counter;
    }

    public void resetCounter() {
        counter = 0;
    }
}
