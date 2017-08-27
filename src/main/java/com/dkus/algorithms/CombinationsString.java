package com.dkus.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author anders.schwartz
 */
public class CombinationsString {

    public static void main(String[] args) {
        List<String> elements = new ArrayList<>();
        elements.add("a");
        elements.add("b");
        elements.add("c");
//        elements.add("d");
//        elements.add("e");
        List<String> combinations = allSubsets(elements);
        Collections.sort(combinations);
        System.out.println(combinations);
        System.out.println(combinations.size());
    }

    public static List<String> allSubsets(List<String> elements) {
        List<String> combinations = new ArrayList<>();

        if (elements.size() == 1) {
            combinations.add("");
            combinations.add(elements.get(0));
            return combinations;
        }

        String lastStr = elements.get(elements.size() - 1);
        List<String> priorCombinations = allSubsets(elements.subList(0, elements.size() - 1));
        combinations.addAll(priorCombinations);

        for (String priorElement : priorCombinations) {
            combinations.add(priorElement + lastStr);
        }
        return combinations;
    }
}