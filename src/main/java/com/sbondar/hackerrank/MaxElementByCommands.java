package com.sbondar.hackerrank;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/maximum-element/problem
You have an empty sequence, and you will be given  queries. Each query is one of these three types:

1 x  -Push the element x into the stack.
2    -Delete the element present at the top of the stack.
3    -Print the maximum element in the stack.
* */

public class MaxElementByCommands {
    public static void main(String[] args) {
        new MaxElementByCommands().maxElement();
    }

    public void maxElement() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        PriorityQueue<Integer> sorted = new PriorityQueue<>(Comparator.reverseOrder());
        for (int l = 0; l < n; l++) {
            int i = s.nextInt();
            if (i == 1) {
                int el = s.nextInt();
                stack.push(el);
                sorted.add(el);
            } else if (i == 2) {
                Integer first = stack.pop();
                sorted.remove(first);
            } else if (i == 3) {
                System.out.println(sorted.peek());
            }
        }
    }
}
