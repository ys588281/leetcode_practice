package com.vincent.leetcode;

import java.util.Stack;

public class AddTwoNumbers2 {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public static void main() {

    }

    public Node addTwoNumbers(Node A, Node B) {
        Node res = null;
        Node temp = res;
        int carry = 0;
        while (A != null || B != null) {
            int sum = 0 + carry;
            if (A != null) {
                sum += A.val;
                A = A.next;
            }
            if (B != null) {
                sum += B.val;
                B = B.next;
            }
            if (sum >= 10) {
                temp.next = new Node(sum % 10);
                carry = 1;
            } else {
                temp.next = new Node(sum);
                carry = 0;
            }
            temp = temp.next;
        }
        if (A != null || B != null || carry != 0) {
            temp.next = new Node(1);
        }
        Stack<Character> stack = new Stack<>();
        stack.peek();
        return res;
    }
}
