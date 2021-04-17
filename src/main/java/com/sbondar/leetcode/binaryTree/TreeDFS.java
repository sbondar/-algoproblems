package com.sbondar.leetcode.binaryTree;


import java.util.ArrayDeque;

//https://tproger.ru/translations/binary-search-tree-for-beginners/

class TreeDFS {

    public TreeNode inOrderTraversal(TreeNode root, int val) {
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
    }
}