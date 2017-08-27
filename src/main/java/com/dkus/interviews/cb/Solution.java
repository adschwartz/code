package com.dkus.interviews.cb;

/**
 *
 * Screen
 *
 * @author anders.schwartz
 */
public class Solution {
    public static void main(String args[]) {
        String s = "The#2(Quick)2Br9own;Fox<Jumped>;2Over8the;La9zy8Dog!!#2";
        // Normally I would check for s being null or empty but no need as it is part of the constraints of the coding task.

        // Create array to store the count of each number (ASCII table contains only 128 characters). All values are automatically initialized to zero in the array:
        int[] asciiArray = new int[128];

        // Count all the occurrences of each character
        for (int i = 0; i < s.length(); i++) {
            int asciiNumber = s.charAt(i);
            asciiArray[asciiNumber]++;
        }

        // Print the occurrences:
        boolean printedTheFirstCharacter = false;
        for (int i = 0; i < asciiArray.length; i++) {
            if (asciiArray[i] > 0) {
                if (printedTheFirstCharacter) {
                    System.out.print(", ");
                }

                char character = (char) i;
                System.out.print(character + ":" + asciiArray[i]);
                printedTheFirstCharacter = true;
            }
        }
        System.out.println();
    }
}
