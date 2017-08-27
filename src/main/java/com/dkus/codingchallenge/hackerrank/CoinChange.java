package com.dkus.codingchallenge.hackerrank;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/coin-change/problem
 * Can you determine the number of ways of making change for n units using the given m types of coins?
 *
 * @author anders.schwartz
 */
public class CoinChange {

    public static void main(String[] args) {
        long n = 10;
        long[] c = {2, 5, 3, 6};
        long ways = getWays(n, c);
        System.out.println("Number of ways: " + ways);
    }

    static long getWays(long n, long[] c) {
        long[][] cache = new long[c.length][(int) n];
        for (long[] cacheInner : cache) {
            Arrays.fill(cacheInner, -1L);
        }
        return getWays(c, c.length, n, cache);
    }

    /**
     * @param c coins
     * @param m number of coins to use to make change
     * @param n the amount to make change for
     * @return
     */
    static long getWays(long[] c, int m, long n, long[][] cache) {
        if (m <= 0 || n < 0) {
            return 0;
        }
        System.out.println(m + "," + n);
        if (n == 0) {
            return 1;
        }

        if (cache[m - 1][(int) n - 1] != -1) {
            return cache[m - 1][(int) n - 1];
        }
        long ways = getWays(c, m - 1, n, cache);
        ways += getWays(c, m, n - c[m - 1], cache);
        cache[m - 1][(int) n - 1] = ways;

        return ways;
    }
}
