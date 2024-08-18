package com.algorithms.bst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;

    @BeforeEach
    public void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    public void testInsertAndContains() {
        // Inserting a variety of elements
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);
        bst.insert(1);
        bst.insert(6);
        bst.insert(8);
        bst.insert(-5);
        bst.insert(20);

        // Verifying presence of inserted elements
        assertTrue(bst.contains(10), "BST should contain 10");
        assertTrue(bst.contains(5), "BST should contain 5");
        assertTrue(bst.contains(15), "BST should contain 15");
        assertTrue(bst.contains(3), "BST should contain 3");
        assertTrue(bst.contains(7), "BST should contain 7");
        assertTrue(bst.contains(12), "BST should contain 12");
        assertTrue(bst.contains(18), "BST should contain 18");
        assertTrue(bst.contains(1), "BST should contain 1");
        assertTrue(bst.contains(6), "BST should contain 6");
        assertTrue(bst.contains(8), "BST should contain 8");
        assertTrue(bst.contains(-5), "BST should contain -5");
        assertTrue(bst.contains(20), "BST should contain 20");

        // Verifying absence of elements not inserted
        assertFalse(bst.contains(0), "BST should not contain 0");
        assertFalse(bst.contains(22), "BST should not contain 22");
        assertFalse(bst.contains(-1), "BST should not contain -1");
        assertFalse(bst.contains(9), "BST should not contain 9");
        assertFalse(bst.contains(30), "BST should not contain 30");
    }

    @Test
    public void testInsertRecursiveAndContains() {
        // Inserting a variety of elements
        bst.insertRecursive(10);
        bst.insertRecursive(5);
        bst.insertRecursive(15);
        bst.insertRecursive(3);
        bst.insertRecursive(7);
        bst.insertRecursive(12);
        bst.insertRecursive(18);
        bst.insertRecursive(1);
        bst.insertRecursive(6);
        bst.insertRecursive(8);
        bst.insertRecursive(-5);
        bst.insertRecursive(20);

        // Verifying presence of inserted elements
        assertTrue(bst.contains(10), "BST should contain 10");
        assertTrue(bst.contains(5), "BST should contain 5");
        assertTrue(bst.contains(15), "BST should contain 15");
        assertTrue(bst.contains(3), "BST should contain 3");
        assertTrue(bst.contains(7), "BST should contain 7");
        assertTrue(bst.contains(12), "BST should contain 12");
        assertTrue(bst.contains(18), "BST should contain 18");
        assertTrue(bst.contains(1), "BST should contain 1");
        assertTrue(bst.contains(6), "BST should contain 6");
        assertTrue(bst.contains(8), "BST should contain 8");
        assertTrue(bst.contains(-5), "BST should contain -5");
        assertTrue(bst.contains(20), "BST should contain 20");

        // Verifying absence of elements not inserted
        assertFalse(bst.contains(0), "BST should not contain 0");
        assertFalse(bst.contains(22), "BST should not contain 22");
        assertFalse(bst.contains(-1), "BST should not contain -1");
        assertFalse(bst.contains(9), "BST should not contain 9");
        assertFalse(bst.contains(30), "BST should not contain 30");
    }

    @Test
    public void testContainsRecursive() {
        // Inserting a variety of elements
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);
        bst.insert(1);
        bst.insert(6);
        bst.insert(8);
        bst.insert(-5);
        bst.insert(20);

        // Verifying presence of inserted elements
        assertTrue(bst.containsRecursive(10), "BST should contain 10");
        assertTrue(bst.containsRecursive(5), "BST should contain 5");
        assertTrue(bst.containsRecursive(15), "BST should contain 15");
        assertTrue(bst.containsRecursive(3), "BST should contain 3");
        assertTrue(bst.containsRecursive(7), "BST should contain 7");
        assertTrue(bst.containsRecursive(12), "BST should contain 12");
        assertTrue(bst.containsRecursive(18), "BST should contain 18");
        assertTrue(bst.containsRecursive(1), "BST should contain 1");
        assertTrue(bst.containsRecursive(6), "BST should contain 6");
        assertTrue(bst.containsRecursive(8), "BST should contain 8");
        assertTrue(bst.containsRecursive(-5), "BST should contain -5");
        assertTrue(bst.containsRecursive(20), "BST should contain 20");

        // Verifying absence of elements not inserted
        assertFalse(bst.containsRecursive(0), "BST should not contain 0");
        assertFalse(bst.containsRecursive(22), "BST should not contain 22");
        assertFalse(bst.containsRecursive(-1), "BST should not contain -1");
        assertFalse(bst.containsRecursive(9), "BST should not contain 9");
        assertFalse(bst.containsRecursive(30), "BST should not contain 30");
    }

    @Test
    public void testInsertDuplicates() {
        bst.insert(10);
        bst.insert(10);

        assertTrue(bst.contains(10), "BST should contain 10");
        // Assuming BST does not add duplicate, contains check would be the same
        // If duplicates are allowed, additional tests would be needed
    }

    @Test
    public void testInsertRecursiveDuplicates() {
        bst.insertRecursive(10);
        bst.insertRecursive(10);

        assertTrue(bst.contains(10), "BST should contain 10");
        // Assuming BST does not add duplicate, contains check would be the same
        // If duplicates are allowed, additional tests would be needed
    }

    @Test
    public void testContainsEmptyTree() {
        assertFalse(bst.contains(10), "Empty BST should not contain any elements");
    }

    @Test
    public void testContainsRecursiveEmptyTree() {
        assertFalse(bst.containsRecursive(10), "Empty BST should not contain any elements");
    }

    @Test
    public void testInsertSingleElement() {
        bst.insert(1);

        assertTrue(bst.contains(1), "BST should contain 1");
        assertFalse(bst.contains(0), "BST should not contain 0");
        assertFalse(bst.contains(2), "BST should not contain 2");
    }

    @Test
    public void testMinimum() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);
        bst.insert(1);
        bst.insert(6);
        bst.insert(8);
        bst.insert(-5);
        bst.insert(20);

        int min = bst.minimum();

        assertEquals(-5, min, "Minimum in the tree should be 1");
    }

    @Test
    public void whenDeleteLeafNode() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        assertTrue(bst.contains(3));
        bst.delete(3);
        assertFalse(bst.contains(3));
    }

    @Test
    public void whenDeleteNodeWithSingleChild() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        assertTrue(bst.contains(5));
        bst.delete(5);
        assertFalse(bst.contains(5));
    }

    @Test
    public void whenDeleteRootNodeWithSingleChild() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(5);
        assertTrue(bst.contains(10));
        bst.delete(10);
        assertFalse(bst.contains(10));
        assertEquals(5, bst.getRoot());
    }

    @Test
    public void whenDeleteRootNodeWithNoChildren() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        assertTrue(bst.contains(10));
        bst.delete(10);
        assertFalse(bst.contains(10));
        assertNull(bst.getRoot());
    }

    @Test
    public void whenDeleteNodeWithTwoChildren() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        assertTrue(bst.contains(5));
        bst.delete(5);
        assertFalse(bst.contains(5));
    }

    @Test
    public void givenExampleTree_whenDeleteRootNode() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(15);
        bst.insert(10);
        bst.insert(20);
        bst.insert(8);
        bst.insert(25);
        assertTrue(bst.contains(15));
        bst.delete(15);
        assertFalse(bst.contains(15));
        assertEquals(20, bst.getRoot());
    }

    @Test
    public void testInvertFunction() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(4);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(9);

        // invert tree
        tree.invert();

        BinarySearchTree.Node rootNode = tree.getRootNode();

        assertNotNull(rootNode);
        assertEquals(4, rootNode.data);
        assertRightNode(rootNode, 2);
        assertLeftNode(rootNode, 7);

        BinarySearchTree.Node left = rootNode.right;
        BinarySearchTree.Node right = rootNode.left;

        assertRightNode(left, 1);
        assertLeftNode(left, 3);
        assertRightNode(right, 6);
        assertLeftNode(right, 9);
    }

    @Test
    public void testBreadthFirstSearchLargeTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);

        List<Integer> expected = Arrays.asList(20, 10, 30, 5, 15, 25, 35);
        List<Integer> actual = tree.breadthFirstSearch();
        assertEquals(expected, actual);
    }

    @Test
    public void testBreadthFirstSearchUnbalancedTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(3);
        tree.insert(2);
        tree.insert(1);

        List<Integer> expected = Arrays.asList(3, 2, 1);
        List<Integer> actual = tree.breadthFirstSearch();
        assertEquals(expected, actual);
    }

    @Test
    public void testDepthFirstSearchPreOrderLargeTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);

        List<Integer> expected = Arrays.asList(20, 10, 5, 15, 30, 25, 35);
        List<Integer> actual = tree.depthFirstSearchPreOrder();
        assertEquals(expected, actual);
    }

    @Test
    public void testDepthFirstSearchPreOrderUnbalancedTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(3);
        tree.insert(2);
        tree.insert(1);

        List<Integer> expected = Arrays.asList(3, 2, 1);
        List<Integer> actual = tree.depthFirstSearchPreOrder();
        assertEquals(expected, actual);
    }

    @Test
    public void testDepthFirstSearchPostOrderLargeTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);

        List<Integer> expected = Arrays.asList(5, 15, 10, 25, 35, 30, 20);
        List<Integer> actual = tree.depthFirstSearchPostOrder();
        assertEquals(expected, actual);
    }

    @Test
    public void testDepthFirstSearchPostOrderUnbalancedTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(3);
        tree.insert(2);
        tree.insert(1);

        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = tree.depthFirstSearchPostOrder();
        assertEquals(expected, actual);
    }

    @Test
    public void testDepthFirstSearchInOrderLargeTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(5);
        tree.insert(15);
        tree.insert(25);
        tree.insert(35);

        List<Integer> expected = Arrays.asList(5, 10, 15, 20, 25, 30, 35);
        List<Integer> actual = tree.depthFirstSearchInOrder();
        assertEquals(expected, actual);
    }

    @Test
    public void testDepthFirstSearchInOrderUnbalancedTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        tree.insert(3);
        tree.insert(2);
        tree.insert(1);

        List<Integer> expected = Arrays.asList(1, 2, 3);
        List<Integer> actual = tree.depthFirstSearchInOrder();
        assertEquals(expected, actual);
    }

    @Test
    public void testInvertEmptyTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.invert();
        assertNull(tree.getRootNode());
    }

    @Test
    public void testInvertSingleElement() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(42);
        tree.invert();
        BinarySearchTree.Node rootNode = tree.getRootNode();
        assertNotNull(rootNode);
        assertEquals(42, rootNode.data);
        assertNull(rootNode.left);
        assertNull(rootNode.right);
    }

    @Test
    public void testInvertTwoElement() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(42);
        tree.insert(21);
        tree.invert();
        BinarySearchTree.Node rootNode = tree.getRootNode();
        assertNotNull(rootNode);
        assertEquals(42, rootNode.data);
        assertNotNull(rootNode.right);
        assertNull(rootNode.left);
        assertEquals(21, rootNode.right.data);
    }

    @Test
    public void testInvertTreeWithOnlyRightChild() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        // The tree now looks like this:
        //     1
        //      \
        //       2
        //        \
        //         3

        tree.invert();

        BinarySearchTree.Node rootNode = tree.getRootNode();
        assertNotNull(rootNode);
        assertEquals(1, rootNode.data);
        assertNull(rootNode.right);
        assertNotNull(rootNode.left);
        assertEquals(2, rootNode.left.data);
        assertNull(rootNode.left.right);
        assertNotNull(rootNode.left.left);
        assertEquals(3, rootNode.left.left.data);
        assertNull(rootNode.left.left.left);
        assertNull(rootNode.left.left.right);
    }

    @Test
    public void testInvertTreeWithOnlyLeftChild() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        // The tree now looks like this:
        //     3
        //    /
        //   2
        //  /
        // 1

        tree.invert();

        BinarySearchTree.Node rootNode = tree.getRootNode();
        assertNotNull(rootNode);
        assertEquals(3, rootNode.data);
        assertNull(rootNode.left);
        assertNotNull(rootNode.right);
        assertEquals(2, rootNode.right.data);
        assertNull(rootNode.right.left);
        assertNotNull(rootNode.right.right);
        assertEquals(1, rootNode.right.right.data);
        assertNull(rootNode.right.right.left);
        assertNull(rootNode.right.right.right);
    }

    @Test
    void testKthSmallest() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(10);
        bst.insert(5);
        bst.insert(20);
        bst.insert(3);
        bst.insert(7);

        // 3 is the smallest, 5 is the 2nd smallest, 7 is the 3rd smallest, 10 is the 4th smallest, 20 is the 5th smallest
        assertEquals(3, bst.kthSmallest(1));
        assertEquals(5, bst.kthSmallest(2));
        assertEquals(7, bst.kthSmallest(3));
        assertEquals(10, bst.kthSmallest(4));
        assertEquals(20, bst.kthSmallest(5));
    }

    private void assertRightNode(BinarySearchTree.Node node, int expected) {
        assertNotNull(node.right);
        assertEquals(expected, node.right.data);
    }

    private void assertLeftNode(BinarySearchTree.Node node, int expected) {
        assertNotNull(node.left);
        assertEquals(expected, node.left.data);
    }
}