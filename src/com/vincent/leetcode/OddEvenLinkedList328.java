package com.vincent.leetcode;

public class OddEvenLinkedList328 {
    public static void main(String[] args) {

    }

    public static ListNode oddEvenLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode root = new ListNode(0);
        ListNode dummy = root;
        ListNode current = head;
        while (current != null && current.next != null) {
            dummy.next = current;
            dummy = dummy.next;
            current = current.next;
            dummy.next = current;
            dummy = dummy.next;
            current = current.next;
        }
        if (current != null) dummy.next = current;
        return root.next;
    }
}
