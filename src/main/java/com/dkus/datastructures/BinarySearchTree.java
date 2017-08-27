package com.dkus.datastructures;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author anders.schwartz
 */

// TODO: ADS: Add check for if it's a BST: Is left child key less than parent?

class BinaryNode<V> {
    private BinaryNode<V> parentNode;
    private BinaryNode<V> leftNode;
    private BinaryNode<V> rightNode;
    private int key = -1;
    private V value;

    BinaryNode(BinaryNode<V> parentNode, int key, V value) {
        this.parentNode = parentNode;
        this.key = key;
        this.value = value;
    }

    BinaryNode<V> getParentNode() {
        return this.parentNode;
    }

    BinaryNode<V> getLeftNode() {
        return this.leftNode;
    }


    BinaryNode<V> getRightNode() {
        return this.rightNode;
    }

    void setParentNode(BinaryNode<V> node) {
        this.parentNode = node;
    }

    void setLeftNode(BinaryNode<V> node) {
        this.leftNode = node;
    }

    void setRightNode(BinaryNode<V> node) {
        this.rightNode = node;
    }

    int getKey() {
        return this.key;
    }

    void setKey(int key) {
        this.key = key;
    }

    V getValue() {
        return this.value;
    }

    void setValue(V value) {
        this.value = value;
    }
}


class BinarySearchTree<V> {
    private BinaryNode<V> rootNode;

    BinaryNode<V> get(int key) throws Exception {
        if (key < 0) {
            throw new Exception("Invalid key. Key must be non-negative.");
        }

        return get(rootNode, key);
    }

    private BinaryNode<V> get(BinaryNode<V> node, int key) {
        if (node == null) return null;

        if (node.getKey() == key) // The key has been found. Return the node.
        {
            return node;
        } else if (key <= node.getKey()) // The key has not been found. Check if we need to look in left subtree
        {
            return get(node.getLeftNode(), key);
        } else if (key > node.getKey()) // The key has not been found. Check if we need to look in right subtree
        {
            return get(node.getRightNode(), key);
        }

        return null;
    }

    BinaryNode<V> put(int key, V value) throws Exception {
        if (key < 0) {
            throw new Exception("Invalid key. Key must be non-negative.");
        }
        if (value == null) {
            throw new Exception("Invalid value. Value must not be null.");
        }

        if (rootNode == null) {
            rootNode = new BinaryNode<>(null, key, value);
            return rootNode;
        }

        return put(rootNode, key, value);
    }

    private BinaryNode<V> put(BinaryNode<V> node, int key, V value) {
        BinaryNode<V> newNode = null;

        if (key <= node.getKey()) {
            if (node.getLeftNode() == null) {
                newNode = new BinaryNode<>(node, key, value);
                node.setLeftNode(newNode);
            } else {
                newNode = put(node.getLeftNode(), key, value);
            }
        } else if (key > node.getKey()) {
            if (node.getRightNode() == null) {
                newNode = new BinaryNode<>(node, key, value);
                node.setRightNode(newNode);
            } else {
                newNode = put(node.getRightNode(), key, value);
            }
        }

        return newNode;
    }

    boolean isUnBalanced() {

        int balance = Math.abs(getMaxDepth(rootNode) - getMinDepth(rootNode));
        return balance > 1;
    }


    private int getMaxDepth(BinaryNode<V> currentNode) {
        if (currentNode == null) return 0;

        return 1 + Math.max(getMaxDepth(currentNode.getLeftNode()), getMaxDepth(currentNode.getRightNode()));
    }

    private int getMinDepth(BinaryNode<V> currentNode) {
        if (currentNode == null)
            return 0;

        return 1 + Math.min(getMinDepth(currentNode.getLeftNode()), getMinDepth(currentNode.getRightNode()));
    }

    void preOrderTraversal() {
        preOrderTraversal(this.rootNode);
    }

    private void preOrderTraversal(BinaryNode<V> rootNode) {
        System.out.println("Key: " + rootNode.getKey() + " Value: " + rootNode.getValue().toString());
        if (rootNode.getLeftNode() != null)
            preOrderTraversal(rootNode.getLeftNode());
        if (rootNode.getRightNode() != null)
            preOrderTraversal(rootNode.getRightNode());
    }

    void postOrderTraversal() {
        postOrderTraversal(this.rootNode);
    }

    private void postOrderTraversal(BinaryNode<V> rootNode) {
        if (rootNode.getLeftNode() != null)
            postOrderTraversal(rootNode.getLeftNode());


        if (rootNode.getRightNode() != null)
            postOrderTraversal(rootNode.getRightNode());

        System.out.println("Key: " + rootNode.getKey() + " Value: " + rootNode.getValue().toString());
    }

    void inOrderTraversal() {
        inOrderTraversal(this.rootNode);
    }

    private void inOrderTraversal(BinaryNode<V> rootNode) {
        if (rootNode.getLeftNode() != null)
            inOrderTraversal(rootNode.getLeftNode());

        System.out.println("Key: " + rootNode.getKey() + " Value: " + rootNode.getValue().toString());

        if (rootNode.getRightNode() != null)
            inOrderTraversal(rootNode.getRightNode());
    }

    BinaryNode<V> depthFirstSearch(int key) {
        return depthFirstSearch(rootNode, key);
    }

    private BinaryNode<V> depthFirstSearch(BinaryNode<V> rootNode, int key) {
        if (rootNode == null) {
            return null;
        }
//        System.out.println("Checking key " + rootNode.getKey());

        if (rootNode.getKey() == key) {
            return rootNode;
        } else {
            BinaryNode<V> nodeInLeftTree = depthFirstSearch(rootNode.getLeftNode(), key);
            if (nodeInLeftTree != null)
                return nodeInLeftTree;

            return depthFirstSearch(rootNode.getRightNode(), key);
        }
    }

    BinaryNode<V> breadthFirstSearch(int key) {
        Queue<BinaryNode<V>> queue = new LinkedList<>();

        if (rootNode != null)
            queue.add(rootNode);

        while (!queue.isEmpty()) {
            BinaryNode<V> currentNode = queue.poll();

//            System.out.println("Checking key " + currentNode.getKey());

            if (currentNode.getLeftNode() != null)
                queue.add(currentNode.getLeftNode());

            if (currentNode.getRightNode() != null)
                queue.add(currentNode.getRightNode());

            if (currentNode.getKey() == key)
                return currentNode;
        }

        return null;
    }

//    boolean matchTrees(BinaryNode<V> leftTreeNode, BinaryNode<V> rightTreeRoot) {
//        if (leftTreeNode == null || rightTreeRoot == null) {
//            return false;
//        }
//
//        if (leftTreeNode.getValue().equals(rightTreeRoot.getValue())) {
//            if (matchTree(leftTreeNode, rightTreeRoot)) {
//                return true;
//            }
//        }
//
//        return matchTrees(leftTreeNode.getLeftNode(), rightTreeRoot) || matchTrees(leftTreeNode.getRightNode(), rightTreeRoot);
//    }

    /**
     * @param leftTreeNode  This tree is larger than the right tree. We will
     * @param rightTreeRoot Smaller tree which we will attempt to find in [[leftTreeNode]].
     * @return True if [[rightTreeRoot]] is found in [[leftTreeNode]]
     * <p>
     * Time complexity: O(logn + m), where n is the number of nodes in leftTreeNode and m is the number of nodes in rightTreeRoot
     */
    boolean matchTrees(BinaryNode<V> leftTreeNode, BinaryNode<V> rightTreeRoot) {
        if (leftTreeNode == null || rightTreeRoot == null) {
            return false;
        }

        if (leftTreeNode.getValue().equals(rightTreeRoot.getValue()) && matchTree(leftTreeNode, rightTreeRoot)) {
            return true;
        } else {
            // As this is a BST we can limit the space we need to search to either the left or right subtree:
            if (rightTreeRoot.getKey() <= leftTreeNode.getKey()) {
                // Right subtree will be in the left subtree of the leftTreeNode, if it exists there at all
                return matchTrees(leftTreeNode.getLeftNode(), rightTreeRoot);
            } else {
                // Right subtree will be in the right subtree of the leftTreeNode
                return matchTrees(leftTreeNode.getRightNode(), rightTreeRoot);
            }
        }
    }

    private boolean matchTree(BinaryNode<V> firstTreeNode, BinaryNode<V> secondTreeNode) {
        if (firstTreeNode == null && secondTreeNode == null) //We have come to the end of the tree
            return true;

        if (firstTreeNode == null || secondTreeNode == null) //One of the nodes are null, so they don't match
            return false;

        if (firstTreeNode.getValue().equals(secondTreeNode.getValue())) {
            return matchTree(firstTreeNode.getLeftNode(), secondTreeNode.getLeftNode()) &&
                    matchTree(firstTreeNode.getRightNode(), secondTreeNode.getRightNode());
        }

        // Data does not match
        return false;
    }


    boolean deleteNode(BinaryNode<V> deleteNode) throws Exception {
        // Case 1: Node is a leaf node. Node can just be deleted.
        if (deleteNode.getLeftNode() == null && deleteNode.getRightNode() == null) {
            connectToParentNode(deleteNode, null);
            return true;
        }

        //Case 2: Node has 2 children. Find child with smallest key and make parent.
        else if (deleteNode.getLeftNode() != null && deleteNode.getRightNode() != null) {
            BinaryNode<V> smallestKey = findSmallestKeyInTree(deleteNode);
            if (smallestKey == null)
                throw new Exception("No node was returned with smallest key.");

            smallestKey.setRightNode(deleteNode.getRightNode());
            connectToParentNode(deleteNode, smallestKey);
            return true;
        }

        //Case 3: Node has 1 child. Connect child with parent to deleteNode.
        else if (deleteNode.getLeftNode() != null || deleteNode.getRightNode() != null) {
            BinaryNode<V> childNode;

            if (deleteNode.getLeftNode() != null)
                childNode = deleteNode.getLeftNode();
            else if (deleteNode.getRightNode() != null)
                childNode = deleteNode.getRightNode();
            else
                throw new Exception("Both Left and Right nodes were unexpectedly null.");

            connectToParentNode(deleteNode, childNode);
            return true;
        }
        return false;
    }

    private void connectToParentNode(BinaryNode<V> currentNode, BinaryNode<V> newNode) {
        BinaryNode<V> parentNode = currentNode.getParentNode();
        if (parentNode.getLeftNode().getKey() == currentNode.getKey()) {
            parentNode.setLeftNode(newNode);
        } else {
            parentNode.setRightNode(newNode);
        }
    }

    BinaryNode<V> findSmallestKeyInTree(BinaryNode<V> startingNode) {
        return findSmallestKeyInTree(startingNode, startingNode);
    }

    private BinaryNode<V> findSmallestKeyInTree(BinaryNode<V> rootNode, BinaryNode<V> smallestNode) {
        if (rootNode == null)
            return null;

        if (rootNode.getKey() < smallestNode.getKey())
            smallestNode = rootNode;

        //Search left and right
        BinaryNode<V> smallestKeyInLeftTree = findSmallestKeyInTree(rootNode.getLeftNode(), smallestNode);
        BinaryNode<V> smallestKeyInRightTree = findSmallestKeyInTree(rootNode.getRightNode(), smallestNode);

        if (smallestKeyInLeftTree != null) {
            if (smallestKeyInLeftTree.getKey() < smallestNode.getKey())
                smallestNode = smallestKeyInLeftTree;
        }
        if (smallestKeyInRightTree != null) {
            if (smallestKeyInRightTree.getKey() < smallestNode.getKey())
                smallestNode = smallestKeyInLeftTree;
        }

        return smallestNode;
    }
}

