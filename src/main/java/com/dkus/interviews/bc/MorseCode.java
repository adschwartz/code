package com.dkus.interviews.bc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anders.schwartz
 */
class MorseCode {

    private static final String DOT = ".";
    private static final String DASH = "-";
    private static final String UNKNOWN = "?";
    private static final Node root = constructTree();

    private static class Node {
        String value;
        Node dot;
        Node dash;

        Node(String value) {
            this.value = value;
        }

        Node(String value, Node dot, Node dash) {
            this.value = value;
            this.dot = dot;
            this.dash = dash;
        }
    }

    private static Node constructTree() {
        Node S = new Node("S");
        Node U = new Node("U");
        Node R = new Node("R");
        Node W = new Node("W");
        Node D = new Node("D");
        Node K = new Node("K");
        Node G = new Node("G");
        Node O = new Node("O");

        Node I = new Node("I", S, U);
        Node A = new Node("A", R, W);
        Node N = new Node("N", D, K);
        Node M = new Node("M", G, O);

        Node E = new Node("E", I, A);
        Node T = new Node("T", N, M);

        return new Node("", E, T);
    }

    public static List<String> possibilities(String word) {
        return possibilities(word, root);
    }

    private static List<String> possibilities(String word, Node node) {

        if (word.isEmpty()) {
            List<String> list = new ArrayList<>();
            if (!node.value.isEmpty()) {
                list.add(node.value);
            }
            return list;
        } else {
            String current = word.substring(0, 1);
            String lastPart = word.substring(1, word.length());

            switch (current) {
                case DOT:
                    return possibilities(lastPart, node.dot);
                case DASH:
                    return possibilities(lastPart, node.dash);
                case UNKNOWN:
                    List<String> possibleValues = possibilities(lastPart, node.dot);
                    possibleValues.addAll(possibilities(lastPart, node.dash));
                    return possibleValues;
                default:
                    throw new AssertionError("Unknown code: " + current);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(possibilities(""));
        System.out.println(possibilities("."));
        System.out.println(possibilities(".-"));
        System.out.println(possibilities(".-."));

        System.out.println(possibilities("?"));
        System.out.println(possibilities("?."));
        System.out.println(possibilities(".?"));
        System.out.println(possibilities("?-?"));
    }
}
