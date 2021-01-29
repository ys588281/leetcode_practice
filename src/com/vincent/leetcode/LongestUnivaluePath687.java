package com.vincent.leetcode;

public class LongestUnivaluePath687 {

    public static void main(String[] args) {

    }

    public static int max = 0;
    public static int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null && root.left == null) return 1;
        return max;
    }

    private static int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int longest = 0;
        if (root.left.val == root.val) longest = l + 1;
        if (root.right.val == root.val) longest = r + 1;
        max = Math.max(max, longest);
        if (root.left.val == root.val && root.right.val == root.val) return Math.max(l, r) + 1;
        if (root.right.val == root.val) return r + 1;
        if (root.left.val == root.val) return l + 1;
        return 0;
    }
}
