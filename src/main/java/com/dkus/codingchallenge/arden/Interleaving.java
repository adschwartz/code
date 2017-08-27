package com.dkus.codingchallenge.arden;

/**
 * http://www.ardendertat.com/2011/10/10/programming-interview-questions-6-combine-two-strings/
 * We are given 3 strings: str1, str2, and str3. Str3 is said to be a shuffle of str1 and str2 if it can be formed by
 * interleaving the characters of str1 and str2 in a way that maintains the left to right ordering of the characters
 * from each string. For example, given str1=”abc” and str2=”def”, str3=”dabecf” is a valid shuffle since it preserves
 * the character ordering of the two strings. So, given these 3 strings write a function that detects whether str3 is
 * a valid shuffle of str1 and str2.
 *
 * @author anders.schwartz
 */
public class Interleaving {

    public static void main(String[] args) {
        String a = "abc";
        String b = "def";
        String c = "dabecf";
        System.out.println(isInterleaved(a, b, c));

        a = "abc";
        b = "def";
        c = "dabfce";
        System.out.println(isInterleaved(a, b, c));

        a = "xax";
        b = "xbx";
        c = "xxabxx";
        System.out.println(isInterleaved(a, b, c));

        a = "xax";
        b = "xbx";
        c = "xabxxx";
        System.out.println(isInterleaved(a, b, c));

        a = "xxx";
        b = "xxx";
        c = "xxxxxx";
        System.out.println(isInterleaved(a, b, c));

        // Note this part fails:
        a = "aac";
        b = "aab";
        c = "aacaab";
        System.out.println(isInterleaved(a, b, c));
    }

    /**
     * This approach uses memoization. If it didn't the time complexity would be O(2^n). But the memoization means
     * that we can lookup previously visited paths.
     */
    public static boolean isInterleaved(String a, String b, String c) {
        if (a.length() != b.length() || c.length() != a.length() + b.length() || c.length() == 0) return false;

        int ap = 0, bp = 0, cp = 0;
        boolean[][] t = new boolean[a.length()][b.length()];
        return isInterleaved(ap, bp, cp, a, b, c, t);
    }

    private static boolean isInterleaved(int ap, int bp, int cp, String a, String b, String c, boolean[][] t) {
        if (cp == c.length() - 1) return true;
        if (ap == a.length() || bp == b.length()) return false;
        if (t[ap][bp]) return false;

        if (c.charAt(cp) == a.charAt(ap) && isInterleaved(ap + 1, bp, cp + 1, a, b, c, t)) {
            return true;
        }
        if (c.charAt(cp) == b.charAt(bp) && isInterleaved(ap, bp + 1, cp + 1, a, b, c, t)) {
            return true;
        }

        // the strings are not interleaved correctly so we memoize the result for future visits:
        t[ap][bp] = true;
        return false;
    }
}
