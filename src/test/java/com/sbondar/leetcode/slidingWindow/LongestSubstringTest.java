package com.sbondar.leetcode.slidingWindow;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringTest {

    private LongestSubstring testee = new LongestSubstring();

    @Test
    void test1() {
        //given
        String testInput = "abcabcbb";

        //when
        int result = testee.lengthOfLongestSubstring(testInput);

        //then
        assertEquals(3, result);
    }

    @Test
    void test2() {
        //given
        String testInput = "bbbbb";

        //when
        int result = testee.lengthOfLongestSubstring(testInput);

        //then
        assertEquals(1, result);
    }

    @Test
    void test3() {
        //given
        String testInput = "pwwkew";

        //when
        int result = testee.lengthOfLongestSubstring(testInput);

        //then
        assertEquals(3, result);
    }

    @Test
    void test4() {
        //given
        String testInput = "abba";

        //when
        int result = testee.lengthOfLongestSubstring(testInput);

        //then
        assertEquals(2, result);
    }
}