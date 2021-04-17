package com.sbondar.leetcode;

import java.util.Arrays;
import java.util.Scanner;


//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
/*
6 8
5 7 7 8 8 10
3,4

6 6
5 7 7 8 8 10
-1,-1

0 0
-1, -1

2 4
1 4
1, 1

1 0
1
-1, -1
* */

public class SearchForRangeBS {

    public static void main(String[] args) {
        new SearchForRangeBS().processNums();
    }

    public void processNums() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int target = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(searchForRange(nums, target)));
    }

    int[] searchForRange(final int[] nums, final int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = nums.length - 1;
        int targedInx = 0;
        while (l < r) {
            int i = (l + r) / 2;
            if (nums[i] <= target) {
                targedInx = i;
                l = i + 1;
            } else {
                r = i;
            }
        }
        if (targedInx < nums.length - 1 && nums[targedInx + 1] == target) {
            targedInx++;
        }
        if (nums[targedInx] != target) {
            return new int[]{-1, -1};
        }

        int j = targedInx;
        while (j >= 0 && nums[j] == target) {
            l = j;
            j--;
        }
        int k = targedInx;
        while (k < nums.length && nums[k] == target) {
            r = k;
            k++;
        }
        return new int[]{l, r};
    }

}
