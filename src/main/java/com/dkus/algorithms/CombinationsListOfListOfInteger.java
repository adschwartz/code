package com.dkus.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anders.schwartz
 */
public class CombinationsListOfListOfInteger {

    public static void main(String[] args) {
        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
//        elements.add(4);
        List<List<Integer>> combinations = allSubsets(elements);
        for (List<Integer> list : combinations) {
            System.out.println(list);
        }
        System.out.println(combinations.size());
    }

    /**
     * Time complexity: O(2^n * n)
     * Data grows: 2^n
     * base: 1 =>     {}, {1}
     * base: 1,2 =>   {}, {1}, {2}, {1,2}
     * base: 1,2,3 => {}, {1}, {2}, {1,2}, {3}, {1,3}, {2,3}, {1,2,3}
     * Pattern: Take the combinations of C(n-1) combine with C(n):
     *
     * @param elements
     * @return
     */
    public static List<List<Integer>> allSubsets(List<Integer> elements) {

        List<List<Integer>> subsets = new ArrayList<>();
        if (elements.size() == 0) {
            subsets.add(null);
        } else if (elements.size() == 1) { // base case: size = 1
            subsets.add(null);
            subsets.add(elements);
        } else { // base case: size > 1
            List<List<Integer>> priorSubsets = allSubsets(elements.subList(0, elements.size() - 1));
            subsets.addAll(priorSubsets);

            // last element is added to all priorSubsets:
            Integer lastElement = elements.get(elements.size() - 1);
            for (List<Integer> priorSubset : priorSubsets) {
                List<Integer> temp = new ArrayList<>();
                if(priorSubset != null) temp.addAll(priorSubset);
                temp.add(lastElement);
                subsets.add(temp);
            }
        }
        return subsets;
    }
}