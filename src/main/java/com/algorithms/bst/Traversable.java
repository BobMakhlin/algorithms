package com.algorithms.bst;

import java.util.List;

public interface Traversable<E> {
    List<E> breadthFirstSearch();
    List<E> depthFirstSearchPreOrder();
    List<E> depthFirstSearchPostOrder();
    List<E> depthFirstSearchInOrder();
}
