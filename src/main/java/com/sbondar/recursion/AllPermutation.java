package com.sbondar.recursion;

import java.util.Arrays;
import java.util.Scanner;

/* Problem from the Shalini's Recursion session:
Given a string, find ALL permutations
Input: “abc”
Output: [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”] (order of output doesn’t matter as long as you’ve got all the permutations)
https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
* */
public class AllPermutation {

    public static void main(String[] args) {
        new AllPermutation().process();
    }

    public void process() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        rec(input.toCharArray(), 0);
    }

    private void rec(final char[] s, int startIdx) {
        if (startIdx == s.length - 1) {
            System.out.println(Arrays.toString(s));
            return;
        }
        for (int i = startIdx; i < s.length; i ++) {
            switchChars (s, i, startIdx);
            rec(s, startIdx + 1);
            switchChars (s, startIdx, i);
        }
    }

    private void switchChars(final char[] s, final int l, final int i) {
        if (l == i) {
            return;
        }
        char a = s[l];
        s[l] = s[i];
        s[i] = a;
    }

}
