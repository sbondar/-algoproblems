package com.sbondar.leetcode.slidingWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockTest {

    private BestTimeToBuyAndSellStock testee = new BestTimeToBuyAndSellStock();

    @Test
    void test1() {
        //given
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        //when
        int result = testee.maxProfit(prices);

        //then
        assertEquals(5, result);
    }

    @Test
    void test2() {
        //given
        int[] prices = new int[]{7, 6, 4, 3, 1};

        //when
        int result = testee.maxProfit(prices);

        //then
        assertEquals(0, result);
    }

}