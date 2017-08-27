package com.dkus.algorithms;

import java.util.Arrays;

/**
 * @author anders.schwartz
 */
public class QuickSort {

    public static void quickSort(int[] array) {
        if (array == null || array.length == 0)
            return;

        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        int pivot = high; // Can also use middle: (low + high) / 2;

        int i = low;
        int j = high;

        while (i <= j) {
            while (array[i] < array[pivot]) {
                ++i;
            }
            while (array[j] > array[pivot]) {
                --j;
            }

            if (i <= j) {
                swapNumbers(array, i, j);
                ++i;
                --j;
            }
        }

        if (i < high)
            quickSort(array, i, high); // Sort upper part of elements
        if (j > low)
            quickSort(array, low, j); // Sort lower part of elements
    }

    private static void swapNumbers(int[] array, int indexA, int indexB) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }

    public static void main(String[] args) {
        {
            int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
            int[] correctArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

            System.out.println("All elements sorted backwards:");
            System.out.println("  - Input   = " + Arrays.toString(array));
            System.out.println("  - Correct = " + Arrays.toString(correctArray));
            QuickSort.quickSort(array);
            System.out.println("  - Result  = " + Arrays.toString(array));
        }

        {
            int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            int[] correctArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

            System.out.println("All elements sorted backwards:");
            System.out.println("  - Input   = " + Arrays.toString(array));
            System.out.println("  - Correct = " + Arrays.toString(correctArray));
            QuickSort.quickSort(array);
            System.out.println("  - Result  = " + Arrays.toString(array));
        }
        {
            int[] array = {5, 4, 8, 3, 6, 1, 9, 7, 2};
            int[] correctArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

            System.out.println("Elements are random:");
            System.out.println("  - Input   = " + Arrays.toString(array));
            System.out.println("  - Correct = " + Arrays.toString(correctArray));
            QuickSort.quickSort(array);
            System.out.println("  - Result  = " + Arrays.toString(array));
        }
        {
            int[] array = {3, 2, 5, 4, 1};
            int[] correctArray = {2, 3, 5, 6, 7, 9, 10, 11, 12, 14};

            System.out.println("Elements are random:");
            System.out.println("  - Input   = " + Arrays.toString(array));
            System.out.println("  - Correct = " + Arrays.toString(correctArray));
            QuickSort.quickSort(array);
            System.out.println("  - Result  = " + Arrays.toString(array));
        }


    }

}