package com.sbondar.hackerrank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private LowestCommonAncestorBST search;

    @BeforeEach
    void setUp() {
        search = new LowestCommonAncestorBST();
    }

    @Test
    void bfsTree() {
        //given
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;

        //when
        int[] result = search.bfs(nums, target);

        //then
        assertArrayEquals(new int[]{3, 4}, result);
    }