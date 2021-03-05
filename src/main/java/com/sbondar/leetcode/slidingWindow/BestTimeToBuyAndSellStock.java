package com.sbondar.leetcode.slidingWindow;

import java.util.Scanner;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
/*
input: [7, 1, 5, 3, 6, 4]
what is the max profit that I can get from buying and selling stock on different days.
assuming: you have to sell the stock AFTER you buy it. 
output: 5
Brute force: 
compare all possible buying prices with selling prices. 
O(N^2) 
 b
[7, 1, 5, 3, 6, 4]
                s
Sliding window technique
1. 2 pointers (starting pointer, end pointer)
2. longest, shortest, minimum, maximum of something 
3. iterable collection ordered 
4. O(N) - time complexity, O(1) - space complexity (not always, but often)
* */

class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        new BestTimeToBuyAndSellStock().process();
    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyingPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            buyingPrice = Math.min(buyingPrice, price);
            maxProfit = Math.max(maxProfit, price - buyingPrice);
        }
        return maxProfit;
    }

    public void process() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scan.nextInt();
        }
        System.out.println(maxProfit(prices));
    }
}