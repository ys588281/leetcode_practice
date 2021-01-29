package com.vincent.leetcode;

public class CircularArrayLoop457 {

    public static void main(String[] args) {

    }

    public static boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean direction = nums[i] >= 0;
            int slow = i;
            int fast = i;
            do {
                slow = helper(nums, direction, slow);
                fast = helper(nums, direction, fast);
                if (fast == -1) {
                    fast = helper(nums, direction, fast);
                }
            } while (slow != -1 && fast != -1 && slow != fast);
            if (slow != -1 && slow == fast) {
                return true;
            }
        }

        return false;
    }

    private static int helper(int[] nums, boolean direction, int idx) {
        boolean newDirection = nums[idx] >= 0;
        if (newDirection != direction) {
            return -1;
        }
        int newIdx = (idx + nums[idx] + nums.length) % nums.length;
        if (newIdx == idx) {
            return -1;
        }
        return newIdx;
    }

}
