package com.algorithms.bst;

import java.util.List;
import java.util.stream.IntStream;

public class BinarySearchTreeUtils {
    public static <E extends Comparable<E>> BinarySearchTree<E> sortedArrayToBST(List<E> list) {
        var bst = new BinarySearchTree<E>();
        if (!list.isEmpty()) {
            buildTreeRecursive(bst, list);
        }
        return bst;
    }

    public static <E extends Comparable<E>> boolean isValidBST(Traversable<E> tree) {
        var itemsInOrder = tree.depthFirstSearchInOrder();
        return IntStream.range(0, itemsInOrder.size() - 1)
                .allMatch(i -> itemsInOrder.get(i).compareTo(itemsInOrder.get(i + 1)) < 0);
    }

    private static <E extends Comparable<E>> void buildTreeRecursive(BinarySearchTree<E> tree, List<E> sublist) {
        var middleItemIndex = sublist.size() % 2 == 0 ? sublist.size() / 2 - 1 : sublist.size() / 2;
        tree.insert(sublist.get(middleItemIndex));
        var left = sublist.subList(0, middleItemIndex);//passing indexes (to identify the value range) might be more efficient that using sublist.
        if (!left.isEmpty()) {
            buildTreeRecursive(tree, left);
        }
        var right = sublist.subList(middleItemIndex + 1, sublist.size());
        if (!right.isEmpty()) {
            buildTreeRecursive(tree, right);
        }
    }
}
