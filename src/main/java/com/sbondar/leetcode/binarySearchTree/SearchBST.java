package com.sbondar.leetcode.binarySearchTree;

//https://leetcode.com/problems/search-in-a-binary-search-tree/
//You are given the root of a binary search tree (BST) and an integer val.
//
//Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
// If such a node does not exist, return null.

class SearchBST {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        if (root.val > val)
            return searchBST ( root.left, val);

        return searchBST(root.right, val);
    }

    public TreeNode searchBSTWithoutRecursion(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > val) {
                cur = cur.left;
            } else if (cur.val < val) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}