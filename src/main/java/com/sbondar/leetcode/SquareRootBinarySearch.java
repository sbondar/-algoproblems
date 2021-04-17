package com.sbondar.leetcode;

import java.util.Scanner;


//https://leetcode.com/explore/learn/card/binary-search/125/template-i/950/
//Given a non-negative integer x, compute and return the square root of x.
//Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

public class SquareRootBinarySearch {

    public static void main(String[] args) {
        new SquareRootBinarySearch().processNums();
    }

    public void processNums() {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        System.out.println(searchSqrt(x));
    }

    private int searchSqrt(final int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long l = 1;
        long r = x;
        int result = -1;
        while (l < r) {
            long i = (l + r) / 2;
            if (Math.abs(i * i - x) < 1) {
                return (int)i;
            }
            if (i * i < x) {
                l = i + 1;
                result = (int)i;
            } else {
                r = i;
            }
        }
        return result;
    }

}