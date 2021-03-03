package com.sbondar.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WoodCutBSTest {

    private WoodCutBS woodCutter;

    @BeforeEach
    void setUp() {
        woodCutter = new WoodCutBS();
    }

    @Test
    void test1() {
        //given
        int[] logs = new int[] {10, 2, 4};
        int k = 3;

        //when
        int result = woodCutter.search(logs, k);

        //then
        assertEquals(4, result);
    }

    @Test
    void test2() {
        //given
        int[] logs = new int[] {232, 124, 456};
        int k = 7;

        //when
        int result = woodCutter.search(logs, k);

        //then
        assertEquals(114, result);
    }

    @Test
    void test3() {
        //given
        int[] logs = new int[] {1, 2, 3};
        int k = 7;

        //when
        int result = woodCutter.search(logs, k);

        //then
        assertEquals(0, result);
    }
}