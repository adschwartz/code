package com.dkus.interviews.fz;

import java.util.Arrays;

/**
 * @author anders.schwartz
 */
class Comparator {

    public boolean compare(int a, int b) {
        return Integer.compare(a, b) == 0;
    }

    public boolean compare(String a, String b) {
        return a.compareTo(b) == 0;
    }

    public boolean compare(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }
}
