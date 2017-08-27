package com.dkus.codingchallenge.hackerrank;

/**
 * @author anders.schwartz
 */
public class AlgoIsBinarySearchTree {

    class Node {
        int data;
        Node left;
        Node right;
    }

    /**
     * Conditions for BST: Left node smaller than parent node. Right node greater than parent.
     * Data should be in the interval 0 <= data <= 10^4
     */
    boolean checkBST(Node root) {
        return checkBST(root, 0, 10000);
    }

    boolean checkBST(Node root, int min, int max) {
        if (root == null) return true;

        if (root.data <= min || root.data >= max) { // The equal signs make checks for duplicates (parent=child)
            return false;
        }

        return checkBST(root.left, min, root.data) && checkBST(root.right, root.data, max);
    }
}
