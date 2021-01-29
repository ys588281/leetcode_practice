package com.vincent.leetcode;

public class PopulatingNextRightPointersInEachNode116 {

    public static void main(String[] args) {

    }

    public static NextNode connect(NextNode root) {
        if (root == null) return root;

        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
        return root;

        // if (root == null) return root;
        // Queue<Node> queue = new LinkedList<>();
        // queue.add(root);
        // while (!queue.isEmpty()) {
        //     int size = queue.size();
        //     Node prev = null;
        //     for (int i = 0; i < size; i++) {
        //         Node t = queue.poll();
        //         t.next = prev;
        //         if (t.right != null) {
        //             queue.add(t.right);
        //         }
        //         if (t.left != null) {
        //             queue.add(t.left);
        //         }
        //         prev = t;
        //     }
        // }
        // return root;
    }
}
