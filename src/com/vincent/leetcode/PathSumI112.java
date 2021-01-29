package com.vincent.leetcode;

public class PathSumI112 {

    public static void main(String[] args) {

    }

    public static boolean pathSumI(TreeNode root, int target) {
        if (root == null) return false;
        return helper(root.left, target - root.val) || helper(root.right, target- root.val);
    }

    private static boolean helper(TreeNode node, int target) {
        if (node == null) return false;
        if (node.right == null && node.left == null && node.val == target) return true;
        return helper(node.left, target - node.val) || helper(node.right, target- node.val);
    }
}
