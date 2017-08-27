package com.dkus.codingchallenge.hackerrank;

import java.util.*;

/**
 * @author anders.schwartz
 */
public class AlgosMissingNumbers {

    /**
     * Options: If there are no time and space constraints then we can allocate two arrays and simply increment
     * in the array index corresponding to the number. If there are then we can create two HashMaps and count.
     */
    public static void missingNumbers(int[] as, int n, int[] bs, int m) {
        assert n < m;
        assert n >= 1 && n <= 200000;
        assert m >= 1 && m <= 200000;

        Map<Integer, Integer> acs = new HashMap<>();
        Map<Integer, Integer> bcs = new HashMap<>();

        for (int a : as) {
            Integer count = acs.get(a);
            if (count != null) {
                acs.put(a, ++count);
            } else {
                acs.put(a, 1);
            }
        }

        for (int b : bs) {
            Integer count = bcs.get(b);
            if (count != null) {
                bcs.put(b, ++count);
            } else {
                bcs.put(b, 1);
            }
        }

        List<Integer> missingKeys = new ArrayList<>();
        Map<Integer, Integer> largestSet = bcs.size() > acs.size() ? bcs : acs;
        Map<Integer, Integer> smallestSet = bcs.size() > acs.size() ? acs : bcs;
        for (Integer key : largestSet.keySet()) {
            Integer smallSetCount = smallestSet.get(key);
            if (smallSetCount == null || !smallSetCount.equals(largestSet.get(key))) {
                missingKeys.add(key);
            }
        }

        Collections.sort(missingKeys);
        StringBuilder sb = new StringBuilder();
        for (Integer key : missingKeys) {
            sb.append(key + " ");
        }
        System.out.println(sb.toString().trim());
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        List<Integer> as = new ArrayList<>();
        List<Integer> bs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            as.add(scan.nextInt());
        }
        int m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            bs.add(scan.nextInt());
        }

        missingNumbers(toArray(as), n, toArray(bs), m);

    }

    public static int[] toArray(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(i -> i).toArray();
    }
}
