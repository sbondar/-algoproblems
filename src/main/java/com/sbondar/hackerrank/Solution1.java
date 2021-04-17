package com.sbondar.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.max;


//https://www.hackerrank.com/challenges/largest-rectangle/problem


public class Solution1 {
    public static void main(String[] args) {
        new Solution1().processHeights();
    }

    static long largestRectangle(int[] h) {
        long s = 0;
        List<Integer> is = new ArrayList<>();
        for (int i = 0; i < h.length; i++) {
            if ((i + 1) < h.length && h[i + 1] >= h[i]) {
                is.add(i);
            } else {
                is.add(i);//?
                int j = is.size()-1;
                while (j >= 0 && h[is.get(j)] > h[i + 1]) {
                    s = max(s, h[is.get(j)] * (i - is.get(j) + 1));
                    is.remove(Integer.valueOf(is.get(j)));
                    j--;
                }
            }
        }
        return s;
}

    public void processHeights() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] h = new int[n];
        for (int l = 0; l < n; l++) {
            h[l] = scan.nextInt();
        }
        System.out.println(largestRectangle(h));
    }
}

/*
5
1 2 3 4 5
9

5
1 2 3 2 3
8

5
11 11 10 10 10
50

5
1 3 5 9 11
18
 * * */