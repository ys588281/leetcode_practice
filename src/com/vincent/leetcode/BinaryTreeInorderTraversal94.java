package com.vincent.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94 {

    public static void main(String[] args) {

    }

    public static List<Integer> binaryTreeInorderTraversal(TreeNode root) {
        if (root == null) return null;
        List<Integer> results = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            results.add(node.val);
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return results;
    }
}
