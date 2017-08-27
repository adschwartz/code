package com.dkus.interviews.vs;

/**
 * An array consists of pairs of duplicate integers in no particular order, except one pair is incomplete.
 * Solution in many levels: O(n^2). Look for all combinations.
 * sort the array in nlogn and loop over and find the missing element
 * Use a hashmap to count the occurrence of each element in O(n) but using O(n) space
 * XOR all elements in O(n) using O(1) space. The value of the cumulative xor at the end is the missing element.
 *
 *
 * @author anders.schwartz
 */
public class FindMissingDuplicate {
}
