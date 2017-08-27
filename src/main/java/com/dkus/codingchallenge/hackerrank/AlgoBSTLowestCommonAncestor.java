package com.dkus.codingchallenge.hackerrank;

/**
 * @author anders.schwartz
 */
public class AlgoBSTLowestCommonAncestor {

    class Node {
        int data;
        Node left;
        Node right;
    }

    static Node lca(Node root, int v1, int v2) {
        if (root == null) return null;

        while (root != null) {
            if (v1 < root.data && v2 < root.data) {
                // Both nodes are left
                root = root.left;
            } else if (v1 > root.data && v2 > root.data) {
                // Both nodes are right -> Go right. Check if v1 or v2 is the parent of the other:
                root = root.right;
            } else {
                // If the children go separate ways, then we've found the lca
                break;
            }
        }
        return root;
    }
}
