package com.vincent.leetcode;

public class FindTheTownJudge997 {

    public static void main(String[] args) {

    }

    public static int findTheTownJudge(int N, int[][] trusts) {
        int[] records = new int[N];
        for (int i = 0; i < trusts.length; i++) {
            records[trusts[i][1] - 1]++;
            records[trusts[i][0] - 1]--;
        }
        for (int i = 0; i < records.length; i++) {
            if (records[i] == N - 1) return i + 1;
        }
        return -1;
    }
}
