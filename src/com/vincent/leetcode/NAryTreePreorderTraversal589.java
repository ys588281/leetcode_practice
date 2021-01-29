package com.vincent.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NAryTreePreorderTraversal589 {

    public static void main(String[] args) {

    }

    public static List<Integer> preOrder(NTreeNode root) {
        if (root == null) return null;
        List<Integer> results = new LinkedList<>();
        helper(root, results);
        return results;
    }

    private static void helper(NTreeNode root, List<Integer> results) {
        if (root == null) return;
        results.add(root.val);
        for (NTreeNode node : root.children) {
            helper(node, results);
        }
    }

    public static List<Integer> preOrderIterate(NTreeNode root) {
        if (root == null) return null;
        List<Integer> results = new LinkedList<>();
        Stack<NTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            NTreeNode node = stack.pop();
            results.add(node.val);
            for (NTreeNode child : root.children) {
                stack.push(child);
            }
        }
        return results;
    }
}
