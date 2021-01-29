package com.vincent.leetcode;

public class MergeTwoBinaryTrees617 {
    public static void main(String[] args) {

    }

    public static TreeNode mergeTwoBinaryTrees(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return null;
        }
        if (s == null) {
            return t;
        }
        if (t == null) {
            return s;
        }
        TreeNode result = new TreeNode(s.getVal() + t.getVal());
        TreeNode root = result;
        helper(root.getLeft(), s.getLeft(), t.getLeft());
        helper(root.getRight(), s.getRight(), t.getRight());
        return result;
    }

    private static void helper(TreeNode root, TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return;
        }
        int sValue = 0, tValue = 0;
        if (s != null) {
            sValue = s.getVal();
        }
        if (t != null) {
            tValue = t.getVal();
        }
        root.setVal(sValue + tValue);
        helper(root.getLeft(), s.getLeft(), t.getLeft());
        helper(root.getRight(), s.getRight(), t.getRight());
    }

}
