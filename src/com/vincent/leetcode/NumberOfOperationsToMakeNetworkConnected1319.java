package com.vincent.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfOperationsToMakeNetworkConnected1319 {

    static class QuickUnionFind {
        public int[] ids;

        public QuickUnionFind(int n) {
            this.ids = new int[n];
            for (int i = 0; i < n; i++) {
                ids[i] = i;
            }
        }

        public boolean union(int p, int q) {
            if (getRoot(p) == getRoot(q)) {
                return false;
            }
            int pRoot = getRoot(p);
            int qRoot = getRoot(q);
            ids[pRoot] = qRoot;
            return true;
        }

        private int getRoot(int input) {
            while (input != ids[input]) {
                input = ids[input];
            }
            return input;
        }

        public boolean find(int p, int q) {
            return getRoot(p) == getRoot(q);
        }
    }

    public static void main(String[] args) {
        int[][] coonections = new int[][]{
                {0, 1}, {0, 2}, {1,2}
        };
        coonections = new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}
        };
        coonections = new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 2}
        };
        coonections = new int[][]{
                {0, 1}, {0, 2}, {3, 4}, {2, 3}
        };
        System.out.println(numberOfOperationsToMakeNetworkConnected(5, coonections));
    }

    public static int numberOfOperationsToMakeNetworkConnected(int n, int[][] connections) {
        QuickUnionFind quickUnionFind = new QuickUnionFind(n);
        int extraConnections = 0;
        for (int i = 0; i < connections.length; i++) {
            if (!quickUnionFind.union(connections[i][0], connections[i][1])) {
                extraConnections++;
            }
        }
        Set<Integer> groupSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            groupSet.add(quickUnionFind.getRoot(i));
        }
        return ((groupSet.size()-1) > extraConnections) ? -1 : groupSet.size()-1;
    }


}
