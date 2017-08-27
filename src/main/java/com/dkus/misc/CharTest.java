package com.dkus.misc;

/**
 * @author anders.schwartz
 */
public class CharTest {

    public static void main(String[] args) {
        char a = 'a';

        System.out.println(a);
        System.out.println((int)a); // WRONG
        System.out.println(Character.getNumericValue(a));

    }
}
