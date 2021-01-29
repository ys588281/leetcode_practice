package com.vincent.leetcode;

public class SortList148 {

    public static void main(String[] args) {

    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    private static ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1), temp = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                temp.next = node1;
                node1 = node1.next;
            }
            if (node1.val > node2.val) {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        if (node1 != null) temp.next = node1;
        if (node2 != null) temp.next = node2;
        return dummy.next;
    }
}
