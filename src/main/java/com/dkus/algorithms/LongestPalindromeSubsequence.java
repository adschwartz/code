package com.dkus.algorithms;

/**
 * O(n^3): http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * O(n^2): http://www.geeksforgeeks.org/?p=19155
 * O(n): http://www.geeksforgeeks.org/manachers-algorithm-linear-time-longest-palindromic-substring-part-1/
 *
 * @author anders.schwartz
 */
public class LongestPalindromeSubsequence {

    public static void main(String[] args) {
        // Approach 1:
        printPalindrome("aba"); // 3
        printPalindrome("abcba"); // 5
        printPalindrome("abcdcba"); // 7
        printPalindrome("abcddcba"); // 8
        printPalindrome("DabcdcbaE"); // 7
        printPalindrome("DabcddcbaE"); // 8

        // Approach 2:
        System.out.println(longestPalindromeNaive("DabcdcbaE"));
    }

    private static void printPalindrome(String s) {
        System.out.println(s + ": " + longestPalindromeWithMemory(s));
    }

    public static int max(int x, int y) {
        return x > y ? x : y;
    }

    /**
     * Approach 1: with memoization (DP): We use caching (l) to avoid having to recompute subtrees.
     * <p>
     * Time complexity: O(n^2)
     * Space complexity: O(n^2)
     * http://www.geeksforgeeks.org/?p=19155
     *
     * @param s
     * @return
     */
    public static int longestPalindromeWithMemory(String s) {
        int n = s.length();
        int[][] l = new int[n][n];

        // The lowest leafs of the tree are all single length palindromes:
        for (int i = 0; i < n; i++) l[i][i] = 1;

        // This data structure is really a tree (although modeled here as an array)
        for (int row = 1; row < n; row++) { // rows
            // Calculate (i,j) in the row. j is offset from i depending on the row. E.g. first coordinate at row 1: (0,1). At row 2: (0,2).
            // Note that i needs to be lt "n-row", because starting at the bottom we have one node less per row
            for (int i = 0; i < n - row; i++) {
                int j = row + i;
                if (s.charAt(i) == s.charAt(j)) {
                    if (row == 1) { // At second lowest row
                        l[i][j] = 2;
                    } else {
                        l[i][j] = l[i + 1][j - 1] + 2; // This is the node 2 levels below this node
                    }
                } else { // chars don't match: Look for longest palindrome in subtree:
                    l[i][j] = max(l[i][j - 1], l[i + 1][j]);
                }
                System.out.println(" " + i + ", " + j + " = " + l[i][j]);
            }
        }
        return l[0][n - 1];
    }

    /**
     * Approach 2: Naive
     */
    public static int longestPalindromeNaive(String s) {
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+2; j <= s.length(); j++) {
                String cs = s.substring(i, j);
                int pl = palindrome(cs);
                if (pl > l) l = pl;
            }
        }
        return l;
    }

    private static int palindrome(String s) {
        StringBuffer reversed = new StringBuffer();
        reversed.append(s);
        reversed.reverse();
        if (s.equals(reversed.toString())) {
            return s.length();
        } else {
            return -1;
        }
    }
}