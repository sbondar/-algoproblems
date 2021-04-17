package com.sbondar.hackerrank;

import java.util.*;

//https://www.hackerrank.com/challenges/find-the-nearest-clone/problem
//Find the nearest clone
//There is a connected undirected graph where each of the nodes is a color. Given a color, find the shortest path connecting any two nodes of that color
/*
4 3
1 2
1 3
4 2
1 2 3 4
2

-1

5 4
1 2
1 3
2 4
3 5
1 2 3 3 2
2

3
* */

//TestCase 10 Terminated due to timeout :(

public class Solution {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     *
     */
    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] colors, int color) {
        //
        Map<Integer, List<Integer>> map = new HashMap<>(graphNodes);
        for (int i = 0; i < graphFrom.length; i++) {
                map.put(i + 1, new ArrayList<>());
            }
        for (int i = 0; i < graphFrom.length; i++) {
            map.get(graphFrom[i]).add(graphTo[i]);
            map.get(graphTo[i]).add(graphFrom[i]);
        }


        int result = -1;
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == color) {
                int d = -1;
                boolean finished = false;
                int depth = 0;
                List<Integer> visited = new ArrayList<>();
                Queue<Node> q = new LinkedList<>();
                q.offer(new Node(i + 1, colors[i + 1 -1], map.get(i + 1)));
                while (!q.isEmpty()) {

                    int levelSize = q.size();
                    for (int j = 0; j < levelSize; j++) {

                        Node current = q.poll();
                        if (current.color == color && depth > 0) {
                            d = depth;
                            finished = true;
                            break;
                        }
                        visited.add(current.index);

                        for (Integer childIdx : current.children) {
                            if (!visited.contains(childIdx)) {
                                q.offer(new Node(childIdx, colors[childIdx-1], map.get(childIdx)));
                            }
                        }
                    }
                    if (finished) break;
                    depth ++;
                }
                //node indexed from 1 => i + 1
                if (d == 1) {
                    return d;
                }
                result = result == -1 ? d : Math.min(d, result);
            }
        }
        return result;
    }

    static class Node {
        int index;
        List<Integer> children;
        long color;

        public Node (final int index, final long color, final List<Integer> children) {
            this.index = index;
            this.color = color;
            this.children = children;
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        System.out.println(String.valueOf(ans));
        scanner.close();
    }
}

