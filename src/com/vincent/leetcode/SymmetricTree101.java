package com.vincent.leetcode;

public class SymmetricTree101 {
    public static void main(String[] args) {

    }

    public static boolean symmetricTree(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.getLeft(), root.getRight());
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return left.getVal() == right.getVal() && isSymmetric(left.getLeft(), right.getRight()) && isSymmetric(left.getRight(), right.getRight());
    }
}
