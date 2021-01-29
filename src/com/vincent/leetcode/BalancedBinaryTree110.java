package com.vincent.leetcode;

public class BalancedBinaryTree110 {

    public static void main(String[] args) {

    }

    public static boolean balancedBinaryTree(TreeNode root) {
        if (root == null) return true;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return balancedBinaryTree(root.left) && balancedBinaryTree(root.right) && Math.abs(left - right) <= 1;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
