package com.sbondar.leetcode.binarySearch;

import java.util.Scanner;


//https://leetcode.com/explore/learn/card/binary-search/126/template-ii/948/
//A peak element is an element that is strictly greater than its neighbors.
//Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
/*
4
1 2 3 1
2

7
1 2 1 3 5 6 4
5
* */

public class PeakElementBinarySearch {

    public static void main(String[] args) {
        new PeakElementBinarySearch().processNums();
    }

    public void processNums() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println(peakEl(nums));
    }

    private int peakEl(final int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int i = (l + r) / 2;
//            if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
//                return i;
//            }
            if (nums[i] > nums[i + 1]) {//this check is enough
                r = i;
            } else {
                l = i + 1;
            }
        }
        return l;
    }

}
/*
We can view any given sequence in numsnums array as alternating ascending and descending sequences.
By making use of this, and the fact that we can return any peak as the result, we can make use of Binary Search to find the required peak element.
In case of simple Binary Search, we work on a sorted sequence of numbers and try to find out the required number by reducing the search space at every step.
In this case, we use a modification of this simple Binary Search to our advantage. We start off by finding the middle element, midmid from the given numsnums array.
If this element happens to be lying in a descending sequence of numbers. or a local falling slope(found by comparing nums[i]nums[i] to its right neighbour),
it means that the peak will always lie towards the left of this element. Thus, we reduce the search space to the left of midmid(including itself) and perform the same process
on left subarray.
* */