package com.vincent.leetcode;

public class PathSumIII437 {

    public static void main(String[] args) {

    }

    public static int pathSumIII(TreeNode root, int sum) {
        if (root == null) return 0;
        return dfs(root, sum) + pathSumIII(root.left, sum - root.val) + pathSumIII(root.right, sum - root.val);
    }

    private static int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        int num = 0;
        if (root.val == sum) num++;

        num = num + dfs(root.left, sum - root.val);
        num = num + dfs(root.right, sum - root.val);
        return num;
    }
}
