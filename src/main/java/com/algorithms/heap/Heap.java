package com.algorithms.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Heap {
    private static final int FIRST_INDEX = 1;
    private final List<Integer> items;
    private final boolean maxHeap;

    public Heap(boolean maxHeap) {
        this.items = new ArrayList<>();
        this.maxHeap = maxHeap;
        items.add(null);
    }

    public Integer peek() {
        if (items.size() == 1) {
            throw new NoSuchElementException();
        }
        return items.get(FIRST_INDEX);
    }

    public int size() {
        return items.size() - 1;
    }

    public void insert(Integer item) {
        items.add(item);
        if (items.size() == 2) {
            // The first item.
            return;
        }
        var newItemIndex = items.size() - 1;
        var parentIndex = getParentIndex(newItemIndex);
        var parent = items.get(parentIndex);

        while (parentIndex != 0 && needToSwapWithParent(item, parent)) {
            // swap
            items.set(newItemIndex, parent);
            items.set(parentIndex, item);
            newItemIndex = parentIndex;

            parentIndex = getParentIndex(newItemIndex);
            parent = items.get(parentIndex);
        }
    }

    public void removeTop() {
        if (items.size() == 1) {
            throw new NoSuchElementException();
        }
        if (items.size() == 2) {
            items.remove(FIRST_INDEX);
            return;
        }
        var last = items.get(items.size() - 1);
        items.set(FIRST_INDEX, last);
        items.remove(items.size() - 1);

        var curIndex = FIRST_INDEX;
        var leftIndex = getLeftChildIndex(curIndex);
        var rightIndex = getRightChildIndex(curIndex);
        var current = items.get(curIndex);
        var left = leftIndex > items.size() - 1 ? null : items.get(leftIndex);
        var right = rightIndex > items.size() - 1 ? null : items.get(rightIndex);

        while (left != null) {
            if (needToSwapWithLeftChild(current, left, right)) {
                items.set(curIndex, left);
                items.set(leftIndex, current);
                curIndex = leftIndex;
            } else if (needToSwapWithRightChild(current, left, right)) {
                items.set(curIndex, right);
                items.set(rightIndex, current);
                curIndex = rightIndex;
            } else {
                // heap is ordered, bail out.
                break;
            }

            leftIndex = getLeftChildIndex(curIndex);
            rightIndex = getRightChildIndex(curIndex);
            current = items.get(curIndex);
            left = leftIndex > items.size() - 1 ? null : items.get(leftIndex);
            right = rightIndex > items.size() - 1 ? null : items.get(rightIndex);
        }

    }

    private boolean needToSwapWithParent(Integer item, Integer parent) {
        return maxHeap ? item > parent : item < parent;
    }

    private boolean needToSwapWithLeftChild(Integer current, Integer leftChild, Integer rightChild) {
        if (maxHeap) {
            var leftIsMax = rightChild == null || leftChild > rightChild;
            return leftIsMax && leftChild > current;
        }
        var leftIsMin = rightChild == null || leftChild < rightChild;
        return leftIsMin && leftChild < current;
    }

    private boolean needToSwapWithRightChild(Integer current, Integer leftChild, Integer rightChild) {
        if (maxHeap) {
            var rightIsMax = rightChild != null && rightChild > leftChild;
            return rightIsMax && rightChild > current;
        }
        var rightIsMin = rightChild != null && rightChild < leftChild;
        return rightIsMin && rightChild < current;
    }

    private int getParentIndex(int i) {
        return i / 2;
    }

    private int getLeftChildIndex(int i) {
        return i * 2;
    }

    private int getRightChildIndex(int i) {
        return i * 2 + 1;
    }
}
