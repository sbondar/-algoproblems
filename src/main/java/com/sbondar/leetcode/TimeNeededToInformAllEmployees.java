package com.sbondar.leetcode;

//https://leetcode.com/problems/time-needed-to-inform-all-employees/
//TODO: bsv: base
//Tree, DFS
// Since it's a tree, we don't need `visited` array

/*
n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
6 2
2 2 -1 2 2 2
0 0 1 0 0 0
1

Input: n = 7, headID = 6, manager = [1,2,3,4,5,6,-1], informTime = [0,6,5,4,3,2,1]
Output: 21
7 6
1 2 3 4 5 6 -1
0 6 5 4 3 2 1
* */

import java.util.*;

public class TimeNeededToInformAllEmployees {

    public int numOfMinutesOptimized(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                tree[manager[i]].add(i);
            }
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();// Since it's a tree, we don't need `visited` array
        Map<Integer, Integer> maxTime = new HashMap<>();
        stack.push(headID);
        maxTime.put(headID, informTime[headID]);
        int result = 0;
        while (!stack.isEmpty()) {
            Integer current = stack.pop();

            if (informTime[current] == 0) {
                result = Math.max(result, maxTime.get(current));
            }
            for (Integer subId : tree[current]) {
                stack.push(subId);
                maxTime.put(subId, maxTime.get(current) + informTime[subId]);
            }
        }
        return result;
    }


    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                map.get(manager[i]).add(i);
            }
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n];
        Map<Integer, Integer> maxTime = new HashMap<>();
        stack.push(headID);
        maxTime.put(headID, informTime[headID]);
        int result = 0;
        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            isVisited[current] = true;

            if (informTime[current] == 0) {
                result = Math.max(result, maxTime.get(current));
            }
            for (Integer subId : map.get(current)) {
                if (!isVisited[subId]) {
                    stack.push(subId);
                    maxTime.put(subId, maxTime.get(current) + informTime[subId]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new TimeNeededToInformAllEmployees().process();
    }

    private void process() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int headID = scan.nextInt();
        int[] manager = new int[n];
        for (int i = 0; i < n; i++) {
            manager[i] = scan.nextInt();
        }
        int[] informTime = new int[n];
        for (int i = 0; i < n; i++) {
            informTime[i] = scan.nextInt();
        }
        System.out.println(numOfMinutes(n, headID, manager, informTime));
    }
}
