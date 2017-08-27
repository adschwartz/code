package com.dkus.codingchallenge;

/**
 * http://www.ardendertat.com/2011/11/21/programming-interview-questions-17-search-unknown-length-array/
 * Given a sorted array of unknown length and a number to search for, return the index of the number in the array.
 * Accessing an element out of bounds throws exception. If the number occurs multiple times, return the index of
 * any occurrence. If it isn’t present, return -1.
 *
 * @author anders.schwartz
 */
public class SearchInArray {

    public static void main(String[] args) {
        int range = 1024;
        int[] arr = new int[range];
        for (int i = 0; i < range; i++) {
            arr[i] = i;
        }
        System.out.println(search(arr, 500));
    }

    /**
     * Binary search through array without knowing the size of the array.
     * Time complexity: O(logn)
     *
     * @param arr
     * @return
     */
    public static int search(int[] arr, int target) {
        int i = 0;
        int right;
        while (true) {
            // Jump right in 2^i increments:
            right = (int) Math.pow(2, i) - 1;
            try {
                if (arr[right] == target) {
                    return right;
                } else if (target < arr[right]) {
                    // Break to do binary search inside the range
                    break;
                }
                i++;
            } catch (IndexOutOfBoundsException e) {
                return -1;
            }
        }

        // binary search:
        int middle;
        int left = (int) Math.pow(2, i - 1);
        while (left <= right) {
            middle = (right - left) / 2 + left;
            if (target == arr[middle]) {
                return middle;
            } else if (target > middle) {
                left = middle;
            } else if (target < middle) {
                right = middle;
            }
        }
        return -1;
    }
}
