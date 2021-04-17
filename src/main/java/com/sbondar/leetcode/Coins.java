package com.sbondar.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
//Given the sorted rotated array nums, return the minimum element of this array.
/*
3
3 1 2
1

2
2 1
1

5
3 4 5 1 2
1

7
4 5 6 7 0 1 2
0

4
11 13 15 17
11
* */
public class Coins {

    public static void main(String[] args) {
        new Coins().procesCoins();
    }

    private void procesCoins() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println(coinChange(nums, a));
    }

    public int coinChange(int[] coins, int amount) {
        List<Integer> sorted = Arrays.stream(coins).boxed().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        int sum = 0;
        int count = 0;
        for (int i = 0; i < sorted.size() && amount > 0; i++) {
            int coin = sorted.get(i);
            count += amount/coin;
            amount = amount%coin;
        }
        return count;

    }
}