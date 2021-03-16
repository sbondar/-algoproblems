package com.sbondar.leetcode.binarySearchTree;

//https://leetcode.com/problems/search-in-a-binary-search-tree/
//You are given the root of a binary search tree (BST) and an integer val.
//
//Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
// If such a node does not exist, return null.

import java.util.ArrayDeque;

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
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode current = root;
        boolean goLeft = true;
        while (!stack.isEmpty()) {
            if (goLeft) {
                while(current.left != null) {
                    stack.push(current);
                    current = current.left;
                    if (current.val == val) {
                        return current;
                    }
                }
            }
            if (current.right != null) {
                current = current.right;
                if (current.val == val) {
                    return current;
                }
                goLeft = true;
            } else {
                current = stack.pop();
                goLeft = false;
            }
        }
        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}