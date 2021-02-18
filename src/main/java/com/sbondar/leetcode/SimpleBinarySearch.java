package com.sbondar.leetcode;

import java.util.Scanner;


//https://leetcode.com/problems/binary-search/
//interval halving (the dichotomy)


public class SimpleBinarySearch {
    public static void main(String[] args) {
        new SimpleBinarySearch().processNums();
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {//null check - in general
            return -1;
        }

        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int i = l + ((r - l + 1) / 2) - 1;
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] < target) {
                l = i + 1;
            } else {
                r = i - 1;
            }
        }
        return nums[l] == target ? l : -1;
    }

    public void processNums() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int t = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println(search(nums, t));
    }

}

/*
6
9
-1 0 3 5 9 12
4

6
2
-1 0 3 5 9 12
-1
*/