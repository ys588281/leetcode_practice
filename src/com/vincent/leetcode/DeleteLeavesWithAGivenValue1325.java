package com.vincent.leetcode;

public class DeleteLeavesWithAGivenValue1325 {

    public static void main(String[] args) {

    }

    public static TreeNode deleteLeavesWithAGivenValue(TreeNode root, int value) {
        if (root == null) return root;
        if (root.right == null && root.left == null && root.val == value) return null;
        if (root.right == null && root.left == null) return root;
        root.left = deleteLeavesWithAGivenValue(root.left, value);
        root.right = deleteLeavesWithAGivenValue(root.right, value);
        return root;
    }
}
