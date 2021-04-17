package com.sbondar.leetcode.binarySearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

//TODO: bsv: add more tests
class SearchForRangeBSTest {

    private SearchForRangeBS search;

    @BeforeEach
    void setUp() {
        search = new SearchForRangeBS();
    }

    @Test
    void searchForRange() {
        //given
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;

        //when
        int[] result = search.searchForRange(nums, target);

        //then
        assertArrayEquals(new int[]{3, 4}, result);
    }
}