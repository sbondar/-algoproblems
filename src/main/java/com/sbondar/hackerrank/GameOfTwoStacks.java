package com.sbondar.hackerrank;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Integer.min;

//https://www.hackerrank.com/challenges/game-of-two-stacks/problem
/*
Alexa has two stacks of non-negative integers, stack  and stack  where index  denotes the top of the stack. Alexa challenges Nick to play the following game:
In each move, Nick can remove one integer from the top of either stack  or stack .
Nick keeps a running sum of the integers he removes from the two stacks.
Nick is disqualified from the game if, at any point, his running sum becomes greater than some integer  given at the beginning of the game.
Nick's final score is the total number of integers he has removed from the two stacks.

1
5 5 20
17 1 1 1 8
8 8 4 5 9

1
5 4 10
4 2 4 6 1
2 1 8 5
* */

public class GameOfTwoStacks {

    static int twoStacks(int x, int[] a, int[] b) {
        int sum = 0;
        int i = 0;
        while (i < a.length && sum + a[i] <= x) {
            sum += a[i];
            i++;
        }
        int score = i;

        int j = 0;
        while (j < b.length) { // review & finish second case
            sum += b[j];
            j++;
            while (sum > x && i > 0) {
                i--;
                sum -= a[i];
            }
            if (sum <= x && i + j > score) {
                score = i + j;
            }
        }
        return score;
    }

    //            int val = stackA.get(i - 1);
//            if (sum - val + stackB.get(j) < x) {
//                sum = sum - val + stackB.get(j);
//                j++;
//            }
    public static void main(String[] args) {
        new GameOfTwoStacks().gameScore();
    }

    static int twoStacks1(int x, int[] a, int[] b) {
        ArrayDeque<Integer> stackA = Arrays.stream(a).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> stackB = Arrays.stream(b).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        return getGameScoreGreedySolution_DoesntWork(stackA, stackB, x);

    }

    public void gameScore() {
        Scanner s = new Scanner(System.in);
        int g = s.nextInt();
        for (int j = 0; j < g; j++) {
            int n = s.nextInt();
            int m = s.nextInt();
            int x = s.nextInt();

            ArrayDeque<Integer> stackA = new ArrayDeque<>();
            ArrayDeque<Integer> stackB = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                stackA.add(s.nextInt());
            }
            for (int i = 0; i < m; i++) {
                stackB.add(s.nextInt());
            }

            System.out.println(getGameScoreGreedySolution_DoesntWork(stackA, stackB, x));

        }
    }


    private static int getGameScoreGreedySolution_DoesntWork(final ArrayDeque<Integer> stackA, final ArrayDeque<Integer> stackB,
                                                             final int x) {
        //Consider two stacks s1 = [17,1,1,1,8] and s2 = [8,8,4,5,9] and max sum = 20.
        int sum = 0;
        int score = 0;
        while (!stackA.isEmpty() && !stackB.isEmpty() && sum <= x) {
            int topA = stackA.peek();
            int topB = stackB.peek();
            int min = min(topA, topB);
            if (min == topA) {
                stackA.pop();
            } else {
                stackB.pop();
            }
            sum += min;
            if (sum <= x) {
                score++;
            }
        }
        while (!stackA.isEmpty() && sum <= x) {
            sum += stackA.pop();
            if (sum <= x) {
                score++;
            }
        }
        while (!stackB.isEmpty() && sum <= x) {
            sum += stackB.pop();
            if (sum <= x) {
                score++;
            }
        }
        return score;
    }
}
