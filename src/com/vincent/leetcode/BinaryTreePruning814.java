package com.vincent.leetcode;

public class BinaryTreePruning814 {

    public static void main(String[] args) {

    }

    public static TreeNode binaryTreePruning(TreeNode root) {
        if (root == null) return root;
        if (root.getVal() == 0 && root.getRight() == null && root.getLeft() == null) return null;
        if (root.getRight() == null && root.getLeft() == null && root.getVal() == 1) return root;
        TreeNode nodeLeft = binaryTreePruning(root.getLeft());
        TreeNode nodeRight = binaryTreePruning(root.getRight());
        if (root.getVal() == 0 && nodeLeft == null && nodeRight == null) return null;
        root.setLeft(nodeLeft);
        root.setRight(nodeRight);
        return root;
    }
}
