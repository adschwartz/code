package com.dkus.algorithms;

/**
 * @author anders.schwartz
 */
public class BinarySearch {

    public static int search(int[] arr, int e) {
        return search(arr, 0, arr.length - 1, e);
    }

    private static int search(int[] arr, int start, int end, int e) {
        if (end < start) return -1; // The element doesn't exist in the array

        int middle = (end - start) / 2 + start;

        if (e == arr[middle]) {
            return middle;
        } else if (e < arr[middle]) {
            return search(arr, start, middle - 1, e);
        } else {
            return search(arr, middle + 1, end, e);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(search(arr, 3)); // Prints 2 (the index of the item)
    }
}
