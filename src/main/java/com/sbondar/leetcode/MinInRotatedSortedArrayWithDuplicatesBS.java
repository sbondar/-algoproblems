package com.sbondar.leetcode;

import java.util.Arrays;
import java.util.Scanner;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
//Given the sorted rotated array nums, return the minimum element of this array. The array may contain duplicates.
/*
5
0 1 10 10 10
0

5
10 1 10 10 10
1

4
3 3 3 1
1

2
1 1
1

3
1 3 5
1

5
2 2 2 0 1
0

3
3 1 3
1
* */
public class MinInRotatedSortedArrayWithDuplicatesBS {

    public static void main(String[] args) {
        new MinInRotatedSortedArrayWithDuplicatesBS().processNums();
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
        if (nums[l] < nums[r]) {//sorted array case
            return nums[l];
        }
        while (l < r) {
            int i = (l + r) / 2;
            if (nums[i] > nums[r]) {
                l = i + 1;
            } else if (nums[i] == nums[r] && i != r) {//because if duplicates, have separated scenario
                if (nums[i] == nums[l] && i != l) {
                    //may not copy subarray, but only send start and end indexes as parameters of searchMin(int[] nums): searchMin(nums, l, i-1), searchMin(nums, i+1, r)
                    int[] left = Arrays.copyOfRange(nums, 0, i);
                    int[] right = Arrays.copyOfRange(nums, i + 1, nums.length);
                    return Math.min(searchMin(left), searchMin(right));
                } else {
                    r = i;
                }
            } else {
                r = i;
            }
        }
        return nums[l];
    }
}