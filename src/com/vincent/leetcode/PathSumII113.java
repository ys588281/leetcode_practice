package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> pathSumII(TreeNode root, int target) {
        if (root == null) return null;
        List<List<Integer>> results = new ArrayList<>();
        helper(root, results, new ArrayList<>(), target);
        return results;
    }

    private static void helper(TreeNode root, List<List<Integer>> results, List<Integer> res, int target) {
        if (root == null) return;
        if (root.left == null && root.right == null && root.val == target) {
            res.add(root.val);
            results.add(new ArrayList<>(res));
            res.remove(res.size() - 1);
        }

        res.add(root.val);
        helper(root.left, results, res, target - root.val);
        helper(root.right, results, res, target - root.val);
        res.remove(res.size() - 1);
    }
}
