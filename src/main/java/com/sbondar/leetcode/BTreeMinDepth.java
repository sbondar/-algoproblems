package com.sbondar.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://leetcode.com/problems/minimum-depth-of-binary-tree/

/*
5
2 3 4 5 6
* */

public class BTreeMinDepth {

    public static int minDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i < size; i++) {
                Node curr = q.poll();
                if(curr.left == null && curr.right == null) {
                    return depth;
                }
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }
    public static class Node {
        int val;
        Node left;
        Node right;

        public Node (int val) {
            this.val = val;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.val) {
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
        scan.close();
        int height = minDepth(root);
        System.out.println(height);
    }

}