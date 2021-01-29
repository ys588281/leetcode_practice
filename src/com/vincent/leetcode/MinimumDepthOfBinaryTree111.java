package com.vincent.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree111 {

    public static void main(String[] args) {

    }

    public static int minimumDepthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            while (size >= 0) {
                size--;
                TreeNode node = queue.poll();
                if (node.getLeft() == null && node.getRight() == null) {
                    return count;
                }
                if (node.getLeft() != null) queue.offer(node.getLeft());
                if (node.getRight() != null) queue.offer(node.getRight());
            }
        }
        return count;
    }

}
