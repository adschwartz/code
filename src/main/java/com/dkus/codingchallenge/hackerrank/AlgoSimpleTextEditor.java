package com.dkus.codingchallenge.hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/simple-text-editor/problem
 *
 * @author anders.schwartz
 */
public class AlgoSimpleTextEditor {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scan = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        String s = "";
        stack.push(s);

        int operations = scan.nextInt();
        for (int i = 0; i < operations; i++) {
            int type = scan.nextInt();

            switch (type) {
                case 1: // Append(W)
                    s += scan.next();
                    stack.push(s);
                    break;

                case 2: // Delete(k)
                    int k = scan.nextInt();
                    s = s.substring(0, s.length() - k);
                    stack.push(s);
                    break;

                case 3: // print(k)
                    System.out.println(s.charAt(scan.nextInt() - 1));
                    break;

                case 4: // undo
                    stack.pop();
                    s = stack.peek();
                    break;
            }
        }
    }
}