package com.vincent.leetcode;

public class LinkedListCycle141 {

    public static void main(String[] args) {

    }

    public boolean linkedListCycle(ListNode listNode) {
        ListNode slow = listNode;
        ListNode fast = listNode;
        if (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode linkedListCycleII(ListNode listNode) {
        ListNode res = null;
        ListNode head = listNode;
        ListNode slow = listNode;
        ListNode fast = listNode;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                res = slow;
            }
        }
        return res;
    }
}
