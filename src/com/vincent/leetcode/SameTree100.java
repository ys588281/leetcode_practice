package com.vincent.leetcode;

public class SameTree100 {

    public static void main(String[] args) {

    }

    public static boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return p.val == q .val && sameTree(p.left, q.left) && sameTree(p.right, q.right);
    }
}
