package com.vincent.leetcode;

public class LowestCommonAncestorOfABinarySearchTree235 {

    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestorOfABinarySearchTree(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestorOfABinarySearchTree(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestorOfABinarySearchTree(root.right, p, q);
        }
        return root;
    }


}
