package com.vincent.leetcode;


public class SubtreeOfAnotherTree572 {

    public static void main(String[] args) {

    }

    public static boolean subtreeOfAnotherTree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (s != null && t == null) {
            return true;
        }
        if (helper(s, t)) {
            return true;
        }
        return subtreeOfAnotherTree(s.getLeft(), t) && subtreeOfAnotherTree(s.getRight(), t);
        }

        private static boolean helper(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.getVal() != t.getVal()) {
            return false;
        }
        return helper(s.getLeft(), t.getLeft()) && helper(s.getRight(), t.getRight());
    }
}
