package com.vincent.leetcode;

public class ReverseLinkedList206 {

    public static void main(String[] args) {

    }

    public static ListNode reverseLinkedList(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode current = null;
        ListNode prev = root;
        while (prev.next != null) {
            ListNode temp = prev.next;
            prev.next = current;
            current = prev;
            prev = temp;
        }
        return prev;
    }
}
