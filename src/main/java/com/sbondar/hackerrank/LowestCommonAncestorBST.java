package com.sbondar.hackerrank;

import java.util.*;

//https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem

class LowestCommonAncestorBST {

    public static Node lca(Node root, int v1, int v2) {
        int min = Math.min(v1, v2);
        int max = Math.max(v1, v2);
        Node current = root;
        while (current != null) {
            if (min <= current.data && current.data <= max) {
                return current;
            }
            if (min > current.data) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return null;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
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
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
