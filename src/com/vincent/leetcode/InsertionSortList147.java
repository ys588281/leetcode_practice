package com.vincent.leetcode;

public class InsertionSortList147 {

    public static void main(String[] args) {

    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode current = head;
        while (current != null) {
            ListNode previous = dummy;
            while (previous.next != null && previous.next.val < current.val) {
                previous = previous.next;
            }
            ListNode temp = current.next;
            current.next = previous.next;
            previous.next = current;
            current = temp;
        }
        return dummy.next;
    }
}
