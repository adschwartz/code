package com.dkus.codingchallenge.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author anders.schwartz
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class l002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode currentNode = head;
        ListNode n1 = l1;
        ListNode n2 = l2;

        while (n1 != null || n2 != null) {
            int n1Number = n1 != null ? n1.val : 0;
            int n2Number = n2 != null ? n2.val : 0;
            int sum = currentNode.val + n1Number + n2Number;
            int carry = sum / 10;
            sum %= 10;

            currentNode.val = sum;

            // Add new node if carry > 0 OR l1 OR l2 has more digits
            if (carry > 0 || ((n1 != null && n1.next != null) || (n2 != null && n2.next != null))) {
                currentNode.next = new ListNode(carry);
            }

            currentNode = currentNode.next;
            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        l002 sol = new l002();
//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
        ListNode n10 = new ListNode(2);
        ListNode n11 = new ListNode(4);
        ListNode n12 = new ListNode(3);
        n10.next = n11;
        n11.next = n12;

        ListNode n20 = new ListNode(5);
        ListNode n21 = new ListNode(6);
        ListNode n22 = new ListNode(4);
        n20.next = n21;
        n21.next = n22;

        ListNode added = sol.addTwoNumbers(n10, n20);
        printNodes(added);

        ListNode added2 = sol.addTwoNumbers(new ListNode(5), new ListNode(5));
        printNodes(added2);

        ListNode n31 = new ListNode(9);
        n31.next = new ListNode(9);
        ListNode added3 = sol.addTwoNumbers(new ListNode(1), n31);
        printNodes(added3);
    }

    private static void printNodes(ListNode node) {
        System.out.println(printList(toList(node)));
    }

    private static String printList(List<Integer> list) {
        return list.stream().map(Object::toString).collect(Collectors.joining(" -> "));
    }

    private static List<Integer> toList(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }

}