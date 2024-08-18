package com.algorithms.sorting;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.ThreadLocalRandom;

public class Benchmarks {
    static final int[] unsortedArray = ThreadLocalRandom.current().ints(100_000).toArray();

    @Benchmark
    public void testBubbleSort() {
        int[] copyOfArray = java.util.Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingUtils.bubbleSort(copyOfArray);
    }

    @Benchmark
    public void testSelectionSort() {
        int[] copyOfArray = java.util.Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingUtils.selectionSort(copyOfArray);
    }

    @Benchmark
    public void testInsertionSort() {
        int[] copyOfArray = java.util.Arrays.copyOf(unsortedArray, unsortedArray.length);
        SortingUtils.insertionSort(copyOfArray);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder().include(Benchmarks.class.getSimpleName()).forks(1).build();
        new Runner(opt).run();
    }

}
