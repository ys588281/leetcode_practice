package com.vincent.leetcode;

public class DiameterOfBinaryTree543 {

    public static void main(String[] args) {

    }

    public static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private static int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, left + right);
        return 1 + Math.max(left, right);
    }
}
