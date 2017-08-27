package com.dkus.interviews.az;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author anders.schwartz
 */
public class AnagramsOfString {

    // Find all the anagrams of needle in haystack. Return the indices of their locations.
    // Similar idea: http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/

    public static void main(String[] args) {
        String[] haystacks = {
                "abdcghbaabcdij",
                "BACDGABCDA",
        };

        String[] needles = {
                "bcda",
                "ABCD",
        };

        for (int i = 0; i < haystacks.length; i++) {
            findAndPrintAnagramIndices(haystacks[i], needles[i]);
            System.out.println();
        }
    }

    public static void findAndPrintAnagramIndices(String haystack, String needle) {
        List<Integer> indices = findAnagramIndices(haystack, needle);
        for (Integer index : indices) {
            System.out.print(index + " ");
        }
    }

    public static List<Integer> findAnagramIndices(String _haystack, String _needle) {
        String needle = _needle.toLowerCase();
        String haystack = _haystack.toLowerCase();

        List<Integer> indices = new ArrayList<>();
        Map<Character, Integer> needleCounts = countOccurrences(needle);

        int i = 0;
        int j = needle.length() - 1;
        int maxWindow = haystack.length() - 1;
        while (j <= maxWindow) {
            String subStr = haystack.substring(i, j + 1);
            Map<Character, Integer> windowCounts = countOccurrences(subStr);
            if (needleCounts.equals(windowCounts)) {
                indices.add(i);
            }
            i++;
            j++;

        }
        return indices;
    }

    private static Map<Character, Integer> countOccurrences(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : input.toCharArray()) {
            Integer count = map.get(c);
            if (count == null) {
                count = 0;
            }
            map.put(c, ++count);
        }
        return map;
    }
}
