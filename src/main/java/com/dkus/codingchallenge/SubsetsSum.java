package com.dkus.codingchallenge;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 * <p>
 * This basically an enumeration of all combinations without replacement that sums to the given sum.
 *
 * @author anders.schwartz
 */
public class SubsetsSum {

    public static void main(String[] args) {
//        int[] numbers = {2, 3, 6};
//        int sum = 6;
//        System.out.println(subsets(numbers, numbers.length, sum));

        int[] numbers = {1, 2, 3};
        int sum = 5;
        System.out.println(subsets(numbers, numbers.length, sum));
    }

    /**
     * This solution is O(2^n).
     */
    public static int subsets(int[] numbers, int n, int sum) {
        if (sum == 0) return 1;
        if (n == 0) return 0;

        return subsets(numbers, n - 1, sum) +  // Excluding the current number
                subsets(numbers, n - 1, sum - numbers[n - 1]); // Including the current number

    }
}
