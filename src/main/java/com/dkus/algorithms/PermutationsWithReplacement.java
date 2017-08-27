package com.dkus.algorithms;

/**
 * In football you can score 2 (safety), 3 (field goal), 6 (touchdown), 7 (touchdown + extra point),
 * or 8 (touchdown + 2-point conversion) points. How many different ways are there to score n number of points?  
 * <p>
 * We need enumerate all the ways 2,3,6,7,8 can be summed to n. This is permutation with replacement.
 * <p>
 * The 5 distinct scores in football can be permuted with replacement in 3125 ways: n=5, r=5: P^R(n,r)
 * https://www.calculatorsoup.com/calculators/discretemathematics/permutationsreplacement.php
 * <p>
 * Here's a sample of the number of ways those 5 values can sum to a value:
 * sum = 6: 3 ways
 * sum = 18: 291 ways
 * sum = 32: 61,306 ways
 *
 * @author anders.schwartz
 */
public class PermutationsWithReplacement {


    public static int ways(int[] arr, int sum) {
        if (sum == 0) return 1;
        if (sum < 0) return 0;

        int ways = 0;
        for (int element : arr) {
            ways += ways(arr, sum - element);
        }
        return ways;
    }

    public static long waysCached(int[] arr, int sum) {
        Long[] cache = new Long[sum];
        return waysCached(arr, cache, sum);
    }

    private static long waysCached(int[] arr, Long[] cached, int sum) {
        if (sum == 0) return 1L;

        Long ways = 0L;
        for (int element : arr) {
            int nextSum = sum - element;
            if (nextSum >= 0) {
                if (cached[nextSum] == null) {
                    cached[nextSum] = waysCached(arr, cached, nextSum);
                }
                ways += cached[nextSum];
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 6, 7, 8};

        System.out.println("Without Caching: ");
        for (int i = 0; i < 55; i++) {
            Long before = System.nanoTime();
//            System.out.println(i+": "+ways(numbers, i));
            ways(numbers, i);
            System.out.println(System.nanoTime() - before);
        }

        System.out.println("With Caching: ");

        for (int i = 0; i < 200; i++) {
            Long before = System.nanoTime();
//            System.out.println(i+": "+waysCached(numbers, i));
            waysCached(numbers, i);
            System.out.println(System.nanoTime() - before);
        }
    }
}
