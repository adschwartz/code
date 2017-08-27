package com.dkus.codingchallenge.arden;

import java.util.Arrays;

/**
 * http://www.ardendertat.com/2011/09/24/programming-interview-questions-3-largest-continuous-sum/
 * Given an array of integers (positive and negative) find the largest continuous sum.
 *
 * Time complexity = O(N)
 * Space complexity = O(1)
 *
 * @author anders.schwartz
 */
public class LargestContinuousSum {

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        lss(a);
    }

    public static int[] lss(int[] a) {
        int cs, ms, s = 0, e = 0;

        if (a.length > 0) {
            ms = a[0];
            cs = a[0];

            for (int i = 1; i < a.length; i++) {
                cs = cs + a[i];
                if (a[i] > cs) {
                    cs = a[i];
                    s = i;
                    e = i;
                }
                if (cs > ms) {
                    ms = cs;
                    e = i;
                }
            }
            int[] b = new int[e - s + 1];
            for (int i = s, j = 0; i <= e; i++) {
                b[j++] = a[i];
            }

            System.out.println("Start = " + s + ", end = " + e);
            System.out.println("Maximum sum = " + ms);
            System.out.println("Largest subarray: " + Arrays.toString(b));
            return b;
        }
        return null;
    }
}
