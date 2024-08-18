package com.algorithms.dynamicprogramming;

public class Main {
    public static void main(String[] args) {
        var math = new Math();

        System.out.println(math.fibonacciOptimized(42));
        System.out.println(math.getCallsCount());

        math.resetCounter();
        System.out.println(math.fibonacci(42));
        System.out.println(math.getCallsCount());
    }
}
