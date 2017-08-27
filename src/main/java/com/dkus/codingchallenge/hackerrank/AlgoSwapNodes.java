package com.dkus.codingchallenge.hackerrank;

import java.util.*;

/**
 * @author anders.schwartz
 */

public class AlgoSwapNodes {

    public AlgoSwapNodes() {
    }

    static class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
        }
    }

    public static void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.key + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void swap(int K, Node root, int depth){
        if(root == null) return;

        if(depth % K == 0){
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        swap(K, root.left, depth + 1);
        swap(K, root.right, depth + 1);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named AlgoSwapNodes. */
        Scanner scan = new Scanner(System.in);

        Node root = new Node(1);
        Node currentNode;

        int N = scan.nextInt();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while ((currentNode = q.poll()) != null) {
            int leftIndex = scan.nextInt();
            if (leftIndex >= 0) {
                currentNode.left = new Node(leftIndex);
                q.add(currentNode.left);
            }
            int rightIndex = scan.nextInt();
            if (rightIndex >= 0) {
                currentNode.right = new Node(rightIndex);
                q.add(currentNode.right);
            }
        }

        int T = scan.nextInt();
        for (int i = 0; i < T; i++) {
            int k = scan.nextInt();
            swap(k, root, 1);
            inOrderTraversal(root);
            System.out.println();
        }
    }
}