package com.dkus.interviews.cb;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aschwartz on 2/19/16.
 */

public class NumberWordsJava {

    private static final int base = 10;

    public static String convert(int inputNumber) {

        List<String> groupWords = new ArrayList<>();
        int number = inputNumber;
        for (Map.Entry<Integer, String> entry : digitGroupsToWords.entrySet()) {
            int exponent = entry.getKey();
            int exponentiation = (int) Math.pow(base, exponent);

            int mostSignificantDigits = number / exponentiation;
            if (mostSignificantDigits > 0) {
                if (exponent > 0) {
                    String groupWord = convert(mostSignificantDigits) + " " + digitGroupsToWords.get(exponent);
                    groupWords.add(groupWord);
                } else { // Special case for tens and single digits:
                    groupWords.add(numberToWord.get(mostSignificantDigits));
                }
                number %= exponentiation;
            }
        }
        return StringUtils.join(groupWords, " ");
    }

    public static void main(String[] args) {

        int number = 1_234_567_891;
        String actual = NumberWordsJava.convert(number);
        System.out.println("Input:  " + number);
        System.out.println("Output: " + actual);
    }

    private static final Map<Integer, String> digitGroupsToWords = new LinkedHashMap<Integer, String>() {{
        put(9, "Billion");
        put(6, "Million");
        put(3, "Thousand");
        put(2, "Hundred");
        put(0, "");
    }};

    private static final Map<Integer, String> numberToWord = new LinkedHashMap<Integer, String>() {{
        put(1, "One");
        put(2, "Two");
        put(3, "Three");
        put(4, "Four");
        put(5, "Five");
        put(6, "Six");
        put(7, "Seven");
        put(8, "Eight");
        put(9, "Nine");
        put(10, "Ten");
        put(11, "Eleven");
        put(12, "Twelve");
        put(13, "Thirteen");
        put(14, "Fourteen");
        put(15, "Fifteen");
        put(16, "Sixteen");
        put(17, "Seventeen");
        put(18, "Eighteen");
        put(19, "Nineteen");
        put(20, "Twenty");
        put(21, "Twenty-One");
        put(22, "Twenty-Two");
        put(23, "Twenty-Three");
        put(24, "Twenty-Four");
        put(25, "Twenty-Five");
        put(26, "Twenty-Six");
        put(27, "Twenty-Seven");
        put(28, "Twenty-Eight");
        put(29, "Twenty-Nine");
        put(30, "Thirty");
        put(31, "Thirty-One");
        put(32, "Thirty-Two");
        put(33, "Thirty-Three");
        put(34, "Thirty-Four");
        put(35, "Thirty-Five");
        put(36, "Thirty-Six");
        put(37, "Thirty-Seven");
        put(38, "Thirty-Eight");
        put(39, "Thirty-Nine");
        put(40, "Forty");
        put(41, "Forty-One");
        put(42, "Forty-Two");
        put(43, "Forty-Three");
        put(44, "Forty-Four");
        put(45, "Forty-Five");
        put(46, "Forty-Six");
        put(47, "Forty-Seven");
        put(48, "Forty-Eight");
        put(49, "Forty-Nine");
        put(50, "Fifty");
        put(51, "Fifty-One");
        put(52, "Fifty-Two");
        put(53, "Fifty-Three");
        put(54, "Fifty-Four");
        put(55, "Fifty-Five");
        put(56, "Fifty-Six");
        put(57, "Fifty-Seven");
        put(58, "Fifty-Eight");
        put(59, "Fifty-Nine");
        put(60, "Sixty");
        put(61, "Sixty-One");
        put(62, "Sixty-Two");
        put(63, "Sixty-Three");
        put(64, "Sixty-Four");
        put(65, "Sixty-Five");
        put(66, "Sixty-Six");
        put(67, "Sixty-Seven");
        put(68, "Sixty-Eight");
        put(69, "Sixty-Nine");
        put(70, "Seventy");
        put(71, "Seventy-One");
        put(72, "Seventy-Two");
        put(73, "Seventy-Three");
        put(74, "Seventy-Four");
        put(75, "Seventy-Five");
        put(76, "Seventy-Six");
        put(77, "Seventy-Seven");
        put(78, "Seventy-Eight");
        put(79, "Seventy-Nine");
        put(80, "Eighty");
        put(81, "Eighty-One");
        put(82, "Eighty-Two");
        put(83, "Eighty-Three");
        put(84, "Eighty-Four");
        put(85, "Eighty-Five");
        put(86, "Eighty-Six");
        put(87, "Eighty-Seven");
        put(88, "Eighty-Eight");
        put(89, "Eighty-Nine");
        put(90, "Ninety");
        put(91, "Ninety-One");
        put(92, "Ninety-Two");
        put(93, "Ninety-Three");
        put(94, "Ninety-Four");
        put(95, "Ninety-Five");
        put(96, "Ninety-Six");
        put(97, "Ninety-Seven");
        put(98, "Ninety-Eight");
        put(99, "Ninety-Nine");
    }};
}