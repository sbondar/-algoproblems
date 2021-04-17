package com.sbondar.hackerrank;

import java.util.*;

//https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem
/*
6
4 2 7 1 3 6
2

6
4 1 8 10 9 3
3

7
3 5 2 1 4 6 7
3

1
15
0

5
3 1 7 5 4
3
* */

class BinaryTreeHeight {

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int height = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = q.poll();
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
            height++;
        }
        return height - 1;
    }

    public static int heightDFS(Node root) {//by DFS
        if (root == null) {
            return 0;
        }
        int currentDepth = 1;
        int maxDepth = 1;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        Map<Node, Integer> levels = new HashMap<>();
        stack.push(root);
        Node current = root;
        boolean goLeft = true;
        levels.put(current, currentDepth);
        while (!stack.isEmpty()) {
            if (goLeft) {
                while (current.left != null) {
                    stack.push(current);
                    levels.put(current, currentDepth);
                    current = current.left;
                    currentDepth++;
                }
            }
            if (current.right != null) {
                current = current.right;
                currentDepth++;
                goLeft = true;
            } else {
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                }
                current = stack.pop();
                goLeft = false;
                currentDepth = levels.get(current);
            }
        }
        return maxDepth - 1;
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
        scan.close();
        int height = height(root);
        System.out.println(height);
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
