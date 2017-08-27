package com.dkus.interviews.az;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 * <p>
 * Given an expression string exp , write a program to examine whether the pairs
 * and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp. For example, the
 * program should print true for exp = “[()]{}{[()()]()}” and false for exp = “[(])”
 *
 * 2015
 *
 * @author anders.schwartz
 */
public class BalancedBraces {

    Stack<String> braces = new Stack<>();

    private Map<String, Integer> typeMap = new HashMap<String, Integer>() {{
        put("[", 1);
        put("]", 2);
        put("(", 3);
        put(")", 4);
        put("{", 5);
        put("}", 6);
    }};

    private boolean isClose(String a) {
        return typeMap.get(a) % 2 == 0;
    }

    private boolean sameType(String a, String b) {
        return Math.abs(typeMap.get(a) - typeMap.get(b)) <= 1;
    }

    public boolean validate(String exp) {
        if (exp == null || exp.isEmpty() || exp.length() % 2 != 0) return false;

        boolean result = Arrays.stream(exp.split("")).allMatch(e -> validateSingle(e));
        braces.clear();

        return result;
    }

    private boolean validateSingle(String item) {
        boolean isClosed = isClose(item);

        if (!isClosed) {
            braces.push(item);
        } else if (sameType(braces.peek(), item)) {
            braces.pop();
        } else {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String exp = "[()]{}{[()()]()}";
        BalancedBraces bb = new BalancedBraces();
        System.out.println(bb.validate(exp));

        exp = "[(])";
        System.out.println(bb.validate(exp));

        exp = "{}";
        System.out.println(bb.validate(exp));

        exp = "[]";
        System.out.println(bb.validate(exp));

        exp = "";
        System.out.println(bb.validate(exp));

        exp = "{{{";
        System.out.println(bb.validate(exp));
    }
}