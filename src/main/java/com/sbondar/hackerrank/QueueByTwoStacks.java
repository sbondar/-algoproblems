package com.sbondar.hackerrank;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;


//https://www.hackerrank.com/challenges/queue-using-two-stacks/problem

public class QueueByTwoStacks {
    public static void main(String[] args) {
        new QueueByTwoStacks().maxElement();
    }

    public void maxElement() {//Time limit exceeded
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        MyQueue queue = new MyQueue();
        for (int l = 0; l < n; l++) {
            int i = s.nextInt();
            if (i == 1) {
                int el = s.nextInt();
                queue.add(el);
            } else if (i == 2) {
                queue.removeFirst();
            } else if (i == 3) {
                queue.printFirst();
            }
        }
    }

    private class MyQueue {
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();

        public void add(final int el) {
            stack1.push(el);
        }

        public void removeFirst() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            stack2.pop();
        }

        public void printFirst() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            System.out.println(stack2.peek());
        }
    }
}
