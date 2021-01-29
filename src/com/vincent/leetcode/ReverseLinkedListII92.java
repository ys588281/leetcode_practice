package com.vincent.leetcode;

public class ReverseLinkedListII92 {

    public static void main(String[] args) {

    }

    public ListNode reverseLinkedList(ListNode root, int m, int n) {
        ListNode head = root;
        ListNode first = null;
        ListNode second = null;
        int i = 1;
        while (i < m - 1 || head.next != null) {
            head = head.next;
            i++;
        }
        first = head;
        head = root;
        i = 1;
        while (i < n - 1 || head.next != null) {
            head = head.next;
            i++;
        }
        second = head;
        ListNode firstR = first.next;
        ListNode secondR = second.next;
        ListNode temp1 = firstR.next;
        ListNode temp2 = secondR.next;

        first.next = secondR;
        first.next.next = temp1;

        second.next = firstR;
        second.next.next = temp2;

        return root;
    }
}
