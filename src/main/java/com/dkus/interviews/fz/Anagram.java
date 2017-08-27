package com.dkus.interviews.fz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anders.schwartz
 */
public class Anagram {

    public static void main(String[] args) {

        String[] words = {"cinema", "Iceman", "traits", "strait", "test", "door", "rood"};
        Map<String, Integer> anagrams = Anagram.countAnagrams(words);

        System.out.println("Number of anagrams: " + anagrams.size());

        for (String key : anagrams.keySet()) {
            System.out.println(key + ": " + anagrams.get(key));
        }
    }

    private static Map<String, Integer> countAnagrams(String[] words) {
        Map<String, Integer> countedWords = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase().trim();
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            Integer count = countedWords.get(sortedWord);
            if (count == null) {
                countedWords.put(sortedWord, 1);
            } else {
                countedWords.put(sortedWord, count + 1);
            }
        }

        Map<String, Integer> anagrams = new HashMap<>();
        for (String key : countedWords.keySet()) {
            Integer value = countedWords.get(key);
            if (value > 1) {
                anagrams.put(key, value);
            }
        }
        return anagrams;
    }
}
