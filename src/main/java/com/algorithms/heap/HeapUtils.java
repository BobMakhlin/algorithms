package com.algorithms.heap;

import java.util.ArrayList;
import java.util.List;

public class HeapUtils {
    public static int findKthSmallest(int[] nums, int k) {
        var heap = new Heap(true);
        var pos = 1;
        for (var num : nums) {
            if (pos > k) {
                if (num < heap.peek()) {
                    heap.removeTop();
                    heap.insert(num);
                }
            } else {
                heap.insert(num);
            }
            pos++;
        }
        return heap.peek();
    }

    // O(N * logN), Max Heap is an overhead in this case, actually...
    // We could do without it, just keeping the current max value as a local var.
    public static List<Integer> streamMax(int[] nums) {
        var heap = new Heap(true);
        var res = new ArrayList<Integer>();
        for (var num : nums) {
            heap.insert(num);
            res.add(heap.peek());
        }
        return res;
    }
}
