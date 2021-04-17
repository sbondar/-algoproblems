package com.sbondar.leetcode;

import java.util.Scanner;
//TODO: bsv: what is the task?
class Solution1 {
    public static void main(String[] args) {
        new Solution1().process();
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