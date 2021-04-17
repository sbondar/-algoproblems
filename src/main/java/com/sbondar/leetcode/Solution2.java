package com.sbondar.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;




class Solution2 {
    public static void main(String[] args) {
        new Solution2().process();
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> unidueChars = new HashSet<>();
        int l = 0;
        int maxLength;
        for (char c : s.toCharArray()) {
            if (unidueChars.contains(c)) {
            }


        }

        return 0;
    }

    private void rec(final int c, final int i, final int k, final char[] a) {
        if (c <= k - i - 2) {
            a[i] = '(';
            rec(c + 1, i + 1, k, a);
        }
        if (c > 0) {
            a[i] = ')';
            rec(c - 1, i + 1, k, a);
        }
        if (i == k && c == 0) {
            System.out.println(a);
        }
        }

    public void process() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = 0;
        int i = 0;
        int k = n * 2;
        char[] a = new char[k];
        rec(c, i, k, a);
    }
}