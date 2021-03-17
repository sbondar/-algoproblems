package com.sbondar.leetcode.binarySearch;

import java.util.Arrays;
import java.util.Scanner;


//https://www.lintcode.com/problem/wood-cut/
//Given n pieces of wood with length L[i] (integer array). Cut them into small pieces to guarantee you could have equal or more than k pieces
//with the same length. What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.
/*
3 3
10 2 4
4

3 7
232 124 456
114

3 7
1 2 3
0
* */
//Time Complexity: O(n log k) ?

public class WoodCutBS {

    public static void main(String[] args) {
        new WoodCutBS().process();
    }

    private void process() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] logs = new int[n];
        for (int i = 0; i < n; i++) {
            logs[i] = scan.nextInt();
        }
        System.out.println(search(logs, k));
    }

    int search(int[] logs, int k) {
        if (Arrays.stream(logs).sum() < k) {//if logs are too short
            return 0;
        }
        int result = 0;
        int l = 0;
        int r = Arrays.stream(logs).max().getAsInt();//max length of a cut
        while (l <= r) {
            int i = (l + r) / 2;
            if (getCutsNumber(logs, i) >= k) {
                result = i;
                l = i + 1;
            } else {
                r = i - 1;
            }
        }
        return result;
    }

    private int getCutsNumber(final int[] logs, final int i) {
        return Arrays.stream(logs).map(l -> l / i).sum();
    }
}