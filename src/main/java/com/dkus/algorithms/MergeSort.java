package com.dkus.algorithms;

import java.util.Arrays;

/**
 * @author anders.schwartz
 */

public class MergeSort {

    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int low, int high) {
        if (low < high) { // Stop recursion if we get to just having one element
            int middle = (high - low) / 2 + low;
            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);
            combine(array, low, middle, high);
        }
    }

    private static void combine(int[] array, int low, int middle, int high) {
        int[] arrayCopy = new int[array.length];
        for (int i = low; i <= high; i++) {
            arrayCopy[i] = array[i];
        }

        int left = low;
        int right = middle + 1;
        int current = low;

        while (left <= middle && right <= high) {
            if (arrayCopy[left] < arrayCopy[right]) {
                array[current++] = arrayCopy[left++];
            } else {
                array[current++] = arrayCopy[right++];
            }
        }

        // If there are remaining items in the left array then we copy them over
        // because they are larger and sorted than what is already in the array
        int remaining = middle - left;
        for (int k = 0; k <= remaining; k++) {
            array[current + k] = arrayCopy[left + k];
        }
    }

    public static void main(String[] args) {
        {
            int[] array = {9, 5, 2, 1};
            int[] sortedArray = {1, 2, 5, 9};
            MergeSort.mergeSort(array);
            System.out.println(Arrays.toString(sortedArray) + " == " + Arrays.toString(array));
        }
        {
            int[] array = {38, 27, 43, 3, 9, 82, 10};
            int[] sortedArray = {3, 9, 10, 27, 38, 43, 82};
            MergeSort.mergeSort(array);
            System.out.println(Arrays.toString(sortedArray) + " == " + Arrays.toString(array));

        }
    }
}
