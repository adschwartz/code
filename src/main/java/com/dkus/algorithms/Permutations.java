package com.dkus.algorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author anders.schwartz
 */
public class Permutations {


    public static void main(String[] args) {
        // Case 1:
        System.out.println("Case 1: ");
        String input = "abc";
        for (String p : permute(input)) {
            System.out.println(p);
        }

        // Case 2:
        System.out.println("Case 2: ");
        Set<String> permutations = new HashSet<>();
        permutation(permutations, "", input);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    /**
     * Based on CTCI p. 54, 5th ed
     */
    private static List<String> permute(String str) {
        // We could initialize the capacity with size = str.length()!
        List<String> permutations = new ArrayList<>();

        if (str.length() == 1) {
            permutations.add(str);
        } else {
            String lastChar = str.substring(str.length() - 1, str.length());
            List<String> permutation = permute(str.substring(0, str.length() - 1));

            for (String p : permutation) {
                for (int i = 0; i <= p.length(); i++) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(p.substring(0, i));
                    sb.append(lastChar);
                    if (i < p.length()) sb.append(p.substring(i, p.length()));
                    permutations.add(sb.toString());
                }
            }
        }
        return permutations;
    }

    /**
     * Simple, but inefficient enumeration:
     * n = length of string
     * Time: n^n?
     * Space: n^2 (for n chars in the string to a max recursion level of n)
     * <p>
     * Source: http://introcs.cs.princeton.edu/java/23recursion/Permutations.java.html
     * Source: https://en.wikipedia.org/wiki/Permutation#Software_implementations
     */
    private static void permutation(Set<String> permutations, String prefix, String input) {
        int inputLength = input.length();
        if (input == null || inputLength == 0) {
            permutations.add(prefix);
        }

        for (int i = 0; i < inputLength; i++) {
            permutation(permutations, prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1));
        }
    }
}
