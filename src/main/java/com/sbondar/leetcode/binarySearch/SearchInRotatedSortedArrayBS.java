package com.sbondar.leetcode.binarySearch;

import java.util.Scanner;

//https://leetcode.com/explore/learn/card/binary-search/125/template-i/952/
//Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
/*
8 6
8 1 2 3 4 5 6 7
6

5 9
8 9 2 3 4
1

5 1
5 1 2 3 4
1

3 4
5 1 3
-1

8 8
4 5 6 7 8 1 2 3
4

7 0
4 5 6 7 0 1 2
4

7 3
4 5 6 7 0 1 2
-1

1 0
1
-1

* */
public class SearchInRotatedSortedArrayBS {

    public static void main(String[] args) {
        new SearchInRotatedSortedArrayBS().processNums();
    }

    private void processNums() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int t = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println(search(nums, t));
    }

    private int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int i = (l + r) / 2;
            if (nums[i] == target) {
                return i;
            }
            if (nums[l] == target) {
                return l;
            }
            if (nums[r] == target) {
                return r;
            }
            if (nums[i] > target) {//TODO: bsv: not completed, clean up solution
                if (nums[l] > target && nums[l] < nums[i]) {
                    l = i + 1;
                } else {
                    r = i - 1;
                }
            } else {
                if (((nums[l] < target || nums[r] > target) && nums[l] < nums[i]) ||
                        (nums[l] > nums[i] && nums[i] < nums[r] && nums[r] > target)) {
                    l = i + 1;
                } else {
                    r = i - 1;
                }
            }
        }
        return nums[l] == target ? l : -1;
    }
}