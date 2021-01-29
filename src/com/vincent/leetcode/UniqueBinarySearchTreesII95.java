package com.vincent.leetcode;


import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII95 {

    public static void main(String[] args) {
        uniqueBinarySearchTreesII(3);
    }

    public static List<TreeNode> uniqueBinarySearchTreesII(int n) {
        return generateTree(1, n);
    }

    private static List<TreeNode> generateTree(int start, int end) {
        System.out.println(start + " " + end);
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTree(start, i - 1);
            List<TreeNode> rights = generateTree(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
