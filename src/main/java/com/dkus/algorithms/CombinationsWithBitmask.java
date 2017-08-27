package com.dkus.algorithms;

/**
 * Inspired by: http://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
 * <p>
 * Enumerate all combinations (2^N) of a set of n elements using a bitmask. Use the bitmask to extract the
 * elements from the set that go in to a specific combination.
 *
 * @author anders.schwartz
 */
public class CombinationsWithBitmask {

    /**
     * Inspired by: http://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
     * <p>
     * Enumerate all combinations (2^n) of a set of n elements using a bitmask.
     * Use the bitmask to extract the elements from the set that go in to a specific combination.
     * Time complexity: O(2^n * n)
     */
    public static void printCombinations(int[] arr) {

        int combinations = (int) Math.pow(2, arr.length); // 2^n
        System.out.println("Combinations: " + combinations);

        for (int i = 0; i < combinations; i++) {
            String bitMask = Integer.toBinaryString(i);

            System.out.print("Bitmask: " + bitMask + " -> ");
            System.out.print("{ ");
            for (int j = bitMask.length() - 1; j >= 0; j--) {
                if (bitMask.charAt(j) == '1') {
                    int index = arr.length - 1 - (bitMask.length() - 1 - j);
                    System.out.print(arr[index] + " ");
                }
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        printCombinations(arr);
    }
}
