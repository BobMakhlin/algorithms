package com.algorithms.bst;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeUtilsTest {
    @Test
    public void testSortedArrayToBST_WithEvenNumberOfElements() {
        BinarySearchTree<Integer> bst = BinarySearchTreeUtils.sortedArrayToBST(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));

        BinarySearchTree.Node rootNode = bst.getRootNode();

        assertEquals(6, rootNode.data);

        // inspect left tree
        assertEquals(3, rootNode.left.data);
        assertEquals(1, rootNode.left.left.data);
        assertEquals(2, rootNode.left.left.right.data);
        assertNull(rootNode.left.left.left);
        assertEquals(4, rootNode.left.right.data);
        assertNull(rootNode.left.right.left);
        assertEquals(5, rootNode.left.right.right.data);
        assertNull(rootNode.left.right.right.left);
        assertNull(rootNode.left.right.right.right);

        // inspect right tree
        assertEquals(9, rootNode.right.data);
        assertEquals(7, rootNode.right.left.data);
        assertEquals(8, rootNode.right.left.right.data);
        assertNull(rootNode.right.left.right.left);
        assertNull(rootNode.right.left.right.right);
        assertNull(rootNode.right.left.left);
        assertEquals(11, rootNode.right.right.data);
        assertEquals(10, rootNode.right.right.left.data);
        assertNull(rootNode.right.right.left.left);
        assertNull(rootNode.right.right.left.right);
        assertEquals(12, rootNode.right.right.right.data);
        assertNull(rootNode.right.right.right.left);
        assertNull(rootNode.right.right.right.right);
    }

    @Test
    public void testSortedArrayToBST_WithOddNumberOfElements() {
        BinarySearchTree<Integer> bst = BinarySearchTreeUtils.sortedArrayToBST(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        BinarySearchTree.Node rootNode = bst.getRootNode();

        assertEquals(4, rootNode.data);

        // inspect left tree
        assertEquals(2, rootNode.left.data);
        assertEquals(1, rootNode.left.left.data);
        assertNull(rootNode.left.left.left);
        assertNull(rootNode.left.left.right);
        assertEquals(3, rootNode.left.right.data);
        assertNull(rootNode.left.right.left);
        assertNull(rootNode.left.right.right);

        // inspect right tree
        assertEquals(6, rootNode.right.data);
        assertEquals(5, rootNode.right.left.data);
        assertNull(rootNode.right.left.left);
        assertNull(rootNode.right.left.right);
        assertEquals(7, rootNode.right.right.data);
        assertNull(rootNode.right.right.left);
        assertNull(rootNode.right.right.right);
    }

    @Test
    public void testSortedArrayToBST_SingleElementList() {
        BinarySearchTree<Integer> bst = BinarySearchTreeUtils.sortedArrayToBST(Arrays.asList(1));
        var rootNode = bst.getRootNode();
        assertEquals(1, rootNode.data);
        assertNull(rootNode.left);
        assertNull(rootNode.right);
    }

    @Test
    public void testSortedArrayToBST_TwoElementList() {
        BinarySearchTree<Integer> bst = BinarySearchTreeUtils.sortedArrayToBST(Arrays.asList(1, 2));
        var rootNode = bst.getRootNode();
        assertEquals(1, rootNode.data);
        assertEquals(2, rootNode.right.data);
        assertNull(rootNode.left);
    }

    @Test
    public void testSortedArrayToBST_ThreeElementsList() {
        BinarySearchTree<Integer> bst = BinarySearchTreeUtils.sortedArrayToBST(Arrays.asList(1, 2, 3));
        var rootNode = bst.getRootNode();
        assertEquals(2, rootNode.data);
        assertEquals(1, rootNode.left.data);
        assertEquals(3, rootNode.right.data);
    }

    @Test
    public void testSortedArrayToBST_FifteenElements() {
        BinarySearchTree<Integer> bst = BinarySearchTreeUtils.sortedArrayToBST(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        var rootNode = bst.getRootNode();

        assertEquals(8, rootNode.data);

        // inspect left subtree
        assertEquals(4, rootNode.left.data);
        assertEquals(2, rootNode.left.left.data);
        assertEquals(1, rootNode.left.left.left.data);
        assertNull(rootNode.left.left.left.left);
        assertNull(rootNode.left.left.left.right);
        assertEquals(3, rootNode.left.left.right.data);
        assertNull(rootNode.left.left.right.left);
        assertNull(rootNode.left.left.right.right);
        assertEquals(6, rootNode.left.right.data);
        assertEquals(5, rootNode.left.right.left.data);
        assertNull(rootNode.left.right.left.left);
        assertNull(rootNode.left.right.left.right);
        assertEquals(7, rootNode.left.right.right.data);
        assertNull(rootNode.left.right.right.left);
        assertNull(rootNode.left.right.right.right);

        // inspect right subtree
        assertEquals(12, rootNode.right.data);
        assertEquals(10, rootNode.right.left.data);
        assertEquals(9, rootNode.right.left.left.data);
        assertNull(rootNode.right.left.left.left);
        assertNull(rootNode.right.left.left.right);
        assertEquals(11, rootNode.right.left.right.data);
        assertNull(rootNode.right.left.right.left);
        assertNull(rootNode.right.left.right.right);
        assertEquals(14, rootNode.right.right.data);
        assertEquals(13, rootNode.right.right.left.data);
        assertNull(rootNode.right.right.left.left);
        assertNull(rootNode.right.right.left.right);
        assertEquals(15, rootNode.right.right.right.data);
        assertNull(rootNode.right.right.right.left);
        assertNull(rootNode.right.right.right.right);
    }

    @Test
    void testValidBST() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(20);
        bst.insert(3);
        bst.insert(7);

        assertTrue(BinarySearchTreeUtils.isValidBST(bst));
    }

    @Test
    void testInvalidBST() {
        // a way to build an invalid bst :)
        // createNode is package private.
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.getRootNode().left = bst.createNode(20);
        bst.getRootNode().right = bst.createNode(5);

        assertFalse(BinarySearchTreeUtils.isValidBST(bst));
    }
}