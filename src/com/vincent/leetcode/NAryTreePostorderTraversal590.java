package com.vincent.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NAryTreePostorderTraversal590 {

    public static void main(String[] args) {

    }

    public static List<Integer> postOrder(NTreeNode root) {
        if (root == null) return null;
        List<Integer> results = new LinkedList<>();
        helper(root, results);
        return results;
    }

    private static void helper(NTreeNode root, List<Integer> results) {
        if (root == null) return;
        for (NTreeNode node : root.children) {
            helper(node, results);
        }
        results.add(root.val);
    }

    public static List<Integer> postOrderIterate(NTreeNode root) {
        if (root == null) return null;
        List<Integer> results = new LinkedList<>();
        Stack<NTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            NTreeNode node = stack.peek();
            if (node != null && node.children.size() > 0) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            } else {
                node = stack.pop();
                results.add(node.val);
            }
            node.children = null;
        }
        return results;
    }

}
