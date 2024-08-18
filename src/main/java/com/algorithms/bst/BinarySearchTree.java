package com.algorithms.bst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> implements Traversable<E> {
    private Node root;

    public E getRoot() {
        return root != null ? root.data : null;
    }

    Node getRootNode() {
        return root;
    }

    public E kthSmallest(int k) {
        return kthSmallestRecursive(root, k, new int[]{0});
    }

    private E kthSmallestRecursive(Node node, int k, int[] counter) {
        if (node == null) {
            return null;
        }
        var targetInLeftBranch = kthSmallestRecursive(node.left, k, counter);
        if (targetInLeftBranch != null) {
            return targetInLeftBranch;
        }
        if (++counter[0] == k) {
            return node.data;
        }
        return kthSmallestRecursive(node.right, k, counter);
    }

    public List<E> breadthFirstSearch() {
        var list = new ArrayList<E>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var node = queue.poll();
            list.add(node.data);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }

    public List<E> depthFirstSearchPreOrder() {
        var list = new ArrayList<E>();
        depthFirstSearchPreOrderRecursive(root, list);
        return list;
    }

    private void depthFirstSearchPreOrderRecursive(Node node, List<E> list) {
        if (node == null) {
            return;
        }
        list.add(node.data);
        depthFirstSearchPreOrderRecursive(node.left, list);
        depthFirstSearchPreOrderRecursive(node.right, list);
    }

    public List<E> depthFirstSearchPostOrder() {
        var list = new ArrayList<E>();
        depthFirstSearchPostOrderRecursive(root, list);
        return list;
    }

    private void depthFirstSearchPostOrderRecursive(Node node, List<E> list) {
        if (node == null) {
            return;
        }
        depthFirstSearchPostOrderRecursive(node.left, list);
        depthFirstSearchPostOrderRecursive(node.right, list);
        list.add(node.data);
    }

    public List<E> depthFirstSearchInOrder() {
        var list = new ArrayList<E>();
        depthFirstSearchInOrderRecursive(root, list);
        return list;
    }

    private void depthFirstSearchInOrderRecursive(Node node, List<E> list) {
        if (node == null) {
            return;
        }
        depthFirstSearchInOrderRecursive(node.left, list);
        list.add(node.data);
        depthFirstSearchInOrderRecursive(node.right, list);
    }

    public boolean delete(E val) {
        if (root == null) {
            return false;
        }

        Node parentNode = null;
        var currentNode = root;
        while (currentNode != null && currentNode.data.compareTo(val) != 0) {
            if (val.compareTo(currentNode.data) < 0) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else {
                parentNode = currentNode;
                currentNode = currentNode.right;
            }
        }
        if (currentNode == null) {
            // Was not found in the tree.
            return false;
        }

        if (isLeaf(currentNode)) {
            removeLeafNode(parentNode, currentNode);
            return true;
        }
        if (hasOnlyOneChild(currentNode)) {
            removeNodeWithOnlyOneChild(parentNode, currentNode);
            return true;
        }
        removeNodeWithTwoChildren(parentNode, currentNode);
        return true;
    }

    public boolean insert(E val) {
        if (root == null) {
            root = createNode(val);
            return true;
        }
        var currentNode = root;
        while (currentNode != null) {
            var comparison = val.compareTo(currentNode.data);
            if (comparison < 0) {
                if (currentNode.left == null) {
                    currentNode.left = createNode(val);
                    currentNode = null;
                } else {
                    currentNode = currentNode.left;
                }
            } else if (val.compareTo(currentNode.data) > 0) {
                if (currentNode.right == null) {
                    currentNode.right = createNode(val);
                    currentNode = null;
                } else {
                    currentNode = currentNode.right;
                }
            } else {
                return false; // Duplicate.
            }
        }
        return true;
    }

    public boolean insertRecursive(E val) {
        if (root == null) {
            root = createNode(val);
            return true;
        }
        return insertRecursiveInternal(root, val);
    }

    private boolean insertRecursiveInternal(Node currentNode, E val) {
        var comparison = val.compareTo(currentNode.data);
        if (comparison == 0) {
            return false;
        }
        if (comparison < 0) {
            if (currentNode.left == null) {
                currentNode.left = createNode(val);
                return true;
            }
            return insertRecursiveInternal(currentNode.left, val);
        }
        if (currentNode.right == null) {
            currentNode.right = createNode(val);
            return true;
        }
        return insertRecursiveInternal(currentNode.right, val);
    }

    public boolean contains(E val) {
        if (root == null) {
            return false;
        }
        var currentNode = root;
        while (currentNode != null) {
            if (currentNode.data.compareTo(val) == 0) {
                return true;
            }
            if (val.compareTo(currentNode.data) < 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return false;
    }

    public boolean containsRecursive(E val) {
        if (root == null) {
            return false;
        }
        return containsRecursiveInternal(root, val);
    }

    public E minimum() {
        return minimumRecursiveInternal(root).data;
    }

    public void invert() {
        invertRecursiveInternal(root);
    }

    private void invertRecursiveInternal(Node currentNode) {
        if (currentNode == null || isLeaf(currentNode)) {
            return;
        }

        invertRecursiveInternal(currentNode.left);
        invertRecursiveInternal(currentNode.right);
        swapChildNodes(currentNode);
    }

    private Node minimumRecursiveInternal(Node currentNode) {
        if (currentNode.left == null) {
            return currentNode;
        }
        return minimumRecursiveInternal(currentNode.left);
    }

    private boolean containsRecursiveInternal(Node currentNode, E val) {
        if (currentNode == null) {
            return false; // we are out of the tree.
        }
        if (currentNode.data.compareTo(val) == 0) {
            return true;
        }

        if (val.compareTo(currentNode.data) < 0) {
            return containsRecursiveInternal(currentNode.left, val);
        }
        return containsRecursiveInternal(currentNode.right, val);
    }

    Node createNode(E val) {
        var node = new Node();
        node.data = val;
        return node;
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    private boolean hasOnlyOneChild(Node node) {
        return (node.left != null && node.right == null)
                || (node.left == null && node.right != null);
    }

    private Node getSingleChildNode(Node node) {
        return node.left != null ? node.left : node.right;
    }

    private void removeLeafNode(Node parentNode, Node currentNode) {
        if (parentNode == null) {
            // We are dealing with the root.
            root = null;
            return;
        }
        if (parentNode.left == currentNode) {
            parentNode.left = null;
            return;
        }
        if (parentNode.right == currentNode) {
            parentNode.right = null;
        }
    }

    private void removeNodeWithOnlyOneChild(Node parentNode, Node currentNode) {
        if (parentNode == null) {
            // We are dealing with the root.
            root = getSingleChildNode(currentNode);
            return;
        }
        if (parentNode.left == currentNode) {
            parentNode.left = getSingleChildNode(currentNode);
            return;
        }
        if (parentNode.right == currentNode) {
            parentNode.right = getSingleChildNode(currentNode);
        }
    }

    private void removeNodeWithTwoChildren(Node parentNode, Node currentNode) {
        // Node with minimum value in the right branch is the successor.
        var successorNodeParent = currentNode.right;
        var successorNode = currentNode.right;
        while (successorNode.left != null) {
            successorNodeParent = successorNode;
            successorNode = successorNode.left;
        }
        currentNode.data = successorNode.data;

        // Remove the successor.
        if (successorNode == currentNode.right) {
            currentNode.right = currentNode.right.right;
        } else {
            successorNodeParent.left = null;
        }
    }

    private void swapChildNodes(Node parentNode) {
        var left = parentNode.left;
        parentNode.left = parentNode.right;
        parentNode.right = left;
    }

    class Node {
        E data;
        Node left;
        Node right;
    }
}
