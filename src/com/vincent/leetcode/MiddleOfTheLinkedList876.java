package com.vincent.leetcode;

public class MiddleOfTheLinkedList876 {

    public static void main(String[] args) {

    }

    public ListNode middleOfTheLinkedList(ListNode root) {
        if (root == null) {
            return null;
        }
        ListNode slow = root;
        ListNode fast = root;
        while (fast.next != null || fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
