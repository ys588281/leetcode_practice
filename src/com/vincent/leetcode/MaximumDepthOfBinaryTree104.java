package com.vincent.leetcode;

public class MaximumDepthOfBinaryTree104 {

    public static void main(String[] args) {

    }

    public static int maximumDepthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        if (root.getRight() == null && root.getLeft() == null) return 1;
        return dfs(root);
    }

    private static int dfs(TreeNode root) {
        if (root == null) return 0;
        int right = dfs(root.getRight()) + 1;
        int left = dfs(root.getLeft()) + 1;
        return Math.max(right, left) + 1;
    }
}
