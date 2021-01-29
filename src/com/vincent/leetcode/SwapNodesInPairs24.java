package com.vincent.leetcode;

public class SwapNodesInPairs24 {
    public static void main(String[] args) {

    }

    public static ListNode swapNodesInPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = new ListNode(-1);
        ListNode current = result;
        ListNode p = head, q = p.next, r = p.next.next;

        while (p != null && q != null) {
            current.next = q;
            q.next = p;
            p.next = r;
            current = p;
            p = r;
            q = p.next;
            r = p.next.next;
        }
        return result.next;
    }
}