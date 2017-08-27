package com.dkus.codingchallenge.arden;

/**
 * http://www.ardendertat.com/2011/09/29/programming-interview-questions-5-linkedlist-remove-nodes/
 * Given a linkedlist of integers (with an integer value), delete every node of the linkedlist containing that value.
 *
 * @author anders.schwartz
 */
public class LinkedListRemoveNodes {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node n1 = new Node(2);
        root.next = n1;
        Node n2 = new Node(3);
        n1.next = n2;
        Node n3 = new Node(1);
        n2.next = n3;
        Node n4 = new Node(1);
        n3.next = n4;
        Node n5 = new Node(5);
        n4.next = n5;
        printNodes(root);

        Node newNodes = delete(1, root);

        printNodes(newNodes);
    }

    private static void printNodes(Node root) {
        Node n = root;
        while (n != null) {
            System.out.print(n.value + " -> ");
            n = n.next;
        }
        System.out.println("null");
    }

    public static Node delete(int val, Node root) {
        assert root != null;
        Node pn = null;
        Node cn = root;
        long depth = 1;
        while (cn != null) {
            Node nn = cn.next;
            if (cn.value == val) {
                if(pn !=null) {
                    pn.next = nn; // Wire the previous node to the next node (cn will be deleted)
                }
                cn.next = null; // "delete" current node
                depth--;
                if (depth == 0) {
                    root = nn; // Move the root pointer if we have been deleting the first node in the list
                }
            } else {
                pn = cn; // advance previous node pointer to be the current node (before we move forward)
            }
            cn = nn;
            depth++;
        }
        return root;
    }

}

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
    }
}
