package com.sbondar.leetcode;

import java.util.Scanner;

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
public class MinInRotatedSortedArrayBS {

    public static void main(String[] args) {
        new MinInRotatedSortedArrayBS().processNums();
    }

    private void processNums() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println(searchMin(nums));
    }

    private int searchMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] <= nums[r]) {//sorted array case
            return nums[l];
        }
        while (l < r) {
            int i = (l + r) / 2;
            if (nums[i] >= nums[r]) {
                l = i + 1;
            } else {
                r = i;
            }
        }
        return nums[l];
    }
}