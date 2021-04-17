package com.sbondar.leetcode.binaryTree;

import java.util.ArrayDeque;
import java.util.Scanner;

class TreeBFS {

    public static Node doBFS(Node root, int value) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node first = q.poll();
            if (first.data == value) {
                return first;
            } else {
                if (first.left != null) {
                    q.add(first.left);
                }
                if (first.right != null) {
                    q.add(first.right);
                }
            }
        }
        return null;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int value = scan.nextInt();
        scan.close();
        Node ans = doBFS(root, value);
        System.out.println(ans.data);
    }

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
