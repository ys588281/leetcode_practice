package com.vincent.leetcode;

public class SumRootToLeafNumbers129 {

    public static void main(String[] args) {

    }

    public static int sumRootToLeafNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int current) {
        if (root == null) return current;
        if (root.left == null && root.right == null) return current * 10 + root.val;
        current = current * 10 + root.val;
        int leftSum = dfs(root.left, current);
        int rightSum = dfs(root.left, current);
        return leftSum + rightSum;
    }
}
