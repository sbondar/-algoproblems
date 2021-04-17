package com.sbondar.leetcode.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
//Given the root of a binary tree, return its maximum depth. A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//see com.sbondar.hackerrank.BinaryTreeHeight

class MaximumDepthOfBinaryTree {//+ Maximum Depth of Binary Tree problem

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            height++;
        }
        return height;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}