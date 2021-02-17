package com.sbondar.hackerrank;

import java.util.LinkedList;
import java.util.List;

/*
https://www.hackerrank.com/challenges/equal-stacks/problem
You have three stacks of cylinders where each cylinder has the same diameter, but they may vary in height. You can change the height of a stack by removing and discarding its topmost cylinder any number of times.
Find the maximum possible height of the stacks such that all of the stacks are exactly the same height.
This means you must remove zero or more cylinders from the top of zero or more of the three stacks until they are all the same height, then return the height.
* */

public class CStacks {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int s1 = h1.stream().mapToInt(k -> k).sum();
        int s2 = h2.stream().mapToInt(k -> k).sum();
        int s3 = h3.stream().mapToInt(k -> k).sum();

        LinkedList<Integer> hl1 = new LinkedList<>(h1);
        LinkedList<Integer> hl2 = new LinkedList<>(h2);
        LinkedList<Integer> hl3 = new LinkedList<>(h3);

        int min = s1;
        while ((s1 != s2 || s2 != s3) && !hl1.isEmpty() && !hl2.isEmpty() && !hl3.isEmpty()) {
            while (s1 > min) {
                s1 -= hl1.pop();
            }
            if (s1 < min) {
                min = s1;
            }
            while (s2 > min) {
                s2 -= hl2.pop();
            }
            if (s2 < min) {
                min = s2;
            }
            while (s3 > min) {
                s3 -= hl3.pop();
            }
            if (s3 < min) {
                min = s3;
            }
        }
        return s1 != s2 && s2 != s3 ? 0 : min;
    }

    public static void main(String[] args) {
        int result = CStacks.equalStacks(List.of(3, 2, 1, 1, 1), List.of(4, 3, 2), List.of(1, 1, 4, 1));
        System.out.print("result = " + result);
    }
}
