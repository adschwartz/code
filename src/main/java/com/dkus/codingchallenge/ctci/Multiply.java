package com.dkus.codingchallenge.ctci;

/**
 * Gayle CtCi 6th ed: 8.5
 * Write a recursive function to multiply two positive integers without using the * or / operator.
 * You can use addition, subtraction, and bit shifting but you should minimize the number of those operations
 *
 * @author anders.schwartz
 */
public class Multiply {

    public static void main(String[] args) {
        System.out.println(multiply(5, 4));
        System.out.println(multiply(4, 5));
        System.out.println(multiply(20, 10));
        System.out.println(multiply(20, 0));
    }

    public static int multiply(int a, int b) {
        return multiply(a < b ? a : b, a < b ? b : a, 0);
    }

    public static int multiply(int a, int b, int sum) {
        // 5*4 = 5+5+5+5 (5 cumulatively summed 4 times)
        // 5,5,0
        // 5,4,5
        // 5,3,10
        // 5,2,15
        // 5,1,20
        if (b == 0) {
            return sum;
        }

        return multiply(a, b - 1, sum + a);
    }
}
