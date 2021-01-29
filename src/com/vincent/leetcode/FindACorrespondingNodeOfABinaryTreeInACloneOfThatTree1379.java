package com.vincent.leetcode;

public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree1379 {

    public static void main(String[] args) {

    }

    public static TreeNode findACorrespondingNodeOfABinaryTreeInACloneOfThatTree(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || cloned == null) {
            return null;
        }
        if (original == target) return original;

        TreeNode left = findACorrespondingNodeOfABinaryTreeInACloneOfThatTree(original.left, cloned.left, target);

        if (left != null) return left;

        return findACorrespondingNodeOfABinaryTreeInACloneOfThatTree(original.right, cloned.right,target);

    }
}
