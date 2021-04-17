package com.sbondar.hackerrank;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;


//https://www.hackerrank.com/challenges/largest-rectangle/problem
//Time limit exceeded

public class LargestRectangleBruteForce {
    public static void main(String[] args) {
        new LargestRectangleBruteForce().processHeights();
    }

    static long largestRectangle(int[] h) {
        long s = 0;
        for (int i = 0; i < h.length; i++) {
            s = max(s, h[i]);
            int min = h[i];
            for (int j = i - 1; j >= 0; j--) {
                min = min(h[j], min);
                s = max(s, min * (i - j + 1));
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