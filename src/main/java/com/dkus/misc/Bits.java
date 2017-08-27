package com.dkus.misc;

/**
 * @author anders.schwartz
 */
public class Bits {

    public static void main(String[] args) {

        byte a = 0x1;

        a <<= 1;
        System.out.println(a);
        a <<= 1;
        System.out.println(a);
        a <<= 1;
        System.out.println(a);

        int aDec = 12;

        System.out.println(aDec<<2);
    }
}
