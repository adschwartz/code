package com.dkus.codingchallenge.arden;

/**
 * http://www.ardendertat.com/2011/09/27/programming-interview-questions-4-find-missing-element/
 * There is an array of non-negative integers. A second array is formed by shuffling the elements of the first array
 * and deleting a random element. Given these two arrays, find which element is missing in the second array.
 *
 * @author anders.schwartz
 */
public class MissingInArray {

    public static void main(String[] args) {
        int[] a = {-1, 2, 3, 4, 5, 7};
        int[] b = {3, 4, 2, -1, 5};
        System.out.println(findMissingElement(a, b)); // outputs 7
    }

    /**
     * find the missing number in O(n) time and O(1) space.
     */
    public static int findMissingElement(int[] a, int[] b) {
        assert a.length == b.length;

        int k = 0;
        for (int i : a) {
            k ^= i;
        }
        for (int i : b) {
            k ^= i;
        }
        return k;
    }
}
