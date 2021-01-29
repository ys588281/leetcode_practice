package com.vincent.leetcode;

public class LowestCommonAncestorOfABinaryTree236 {

    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestorOfABinaryTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val) return p;
        if (root.val == q.val) return q;

        TreeNode left = lowestCommonAncestorOfABinaryTree(root.left, p, q);
        TreeNode right = lowestCommonAncestorOfABinaryTree(root.right, p, q);

        if (left != null && right != null) return root;
        if (left == null) return right;
        return left;

    }
}
