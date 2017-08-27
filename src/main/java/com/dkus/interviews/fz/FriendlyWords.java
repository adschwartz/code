package com.dkus.interviews.fz;

import java.util.*;

/**
 * @author anders.schwartz
 */
public class FriendlyWords {

    static String[] friendlyWords(String[] input) {
        // Check null or empty array
        if (input == null || input.length == 0) {
            return new String[]{};
        }

        Map<String, List<String>> friendlyWords = new HashMap<>();

        for (String originalWord : input) {
            String word = originalWord.toLowerCase().trim();

            // Sort the chars of the string to provide a stable representation:
            String sortedWord = sortChars(word);

            List<String> otherWords = friendlyWords.get(sortedWord);
            if (otherWords == null) {
                otherWords = new ArrayList<>();
                friendlyWords.put(sortedWord, otherWords);
            }
            otherWords.add(originalWord);
        }

        List<String> finalWords = new ArrayList<>();

        for (List<String> words : friendlyWords.values()) {
            if (words.size() < 2) continue;
            Collections.sort(words);
            finalWords.add(String.join(" ", words));
        }

        Collections.sort(finalWords);
        return finalWords.toArray(new String[]{});
    }

    /**
     * Sorts the characters of a given word
     *
     * @param word String containing chars to be sorted
     * @return String containing sorted chars
     */
    private static String sortChars(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static void main(String[] args) {
        String[] a = "car cheating dale deal lead listen silent teaching".split(" ");

        try {
            for (String words : friendlyWords(a)) {
                System.out.println(words);
            }
        } catch (Exception e) {
            System.out.println("Unhandled exception!");
        }

    }
}
