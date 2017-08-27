package com.dkus.codingchallenge.ctci;

/**
 * CtCi 6th ed, question 17.18
 * You are given two arrays, one short (with all distinct elements) and one longer.
 * Find the shortest subarray in the longer array that contains all the elements in the shorter array.
 * The items can appear in any order.
 * <p>
 * Example:                  0 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7           _______
 * Input: a = {1,5,9} | b = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7}
 * Output: [7,10] (i.e. the 5,7,9,1 sequence)
 *
 * All the sub sequences:
 * 5,9,0,2,1
 * 9,0,2,1,3,5
 * 1,3,5,7,9
 * 5,7,9,1
 * 9,1,1,5
 * 1,1,5,8,8,9
 * 1,5,8,8,9
 * Pattern: Loop over each element in b. If it matches any element in a then start a sequence.
 * O(a*b) => O(n^2)
 *
 * Goal: T: O(n), S: O(1)
 * Loop over b in O(n).
 * We need to count if all three elements are present in the sub sequence
 * count locations of each element in an array of length a.length
 * ac = [-1,-1,-1]
 * ac = [-1, 1,-1]
 * ac = []
 * int low = 1
 * int high = 5
 * Running distance: 5-1 = 4
 * int low = 2
 * int high = 7
 * Running distance: 7-2 = 5
 * O(n) space with hashmap to keep
 *
 * when you have all three then increment low by one until you find the next "a number"
 * then increment the other two pointers till we have one of each.
 *
 *
 * Use a hashset for a, so you can look up in O(1)
 *
 * @author anders.schwartz
 */
public class ShortestSuperSequence {

//    public int[] shortestSequence(int[] a, int[] b){
//
//
//
//    }
}
