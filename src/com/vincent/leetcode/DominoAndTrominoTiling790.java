package com.vincent.leetcode;

public class DominoAndTrominoTiling790 {

    public static void main(String[] args) {
        System.out.println(dominoAndTrominoTiling(3));
    }

//    https://leetcode.com/problems/domino-and-tromino-tiling/discuss/116581/Detail-and-explanation-of-O(n)-solution-why-dpn2*dn-1+dpn-3
//    https://www.cnblogs.com/grandyang/p/9179556.html
    public static int dominoAndTrominoTiling(int N) {

        int md = 7;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= N; i++) {
            dp[i] = 2 * dp[i - 1] + dp[i - 3];
            dp[i] %= md;
        }
        return dp[N];
    }
}
