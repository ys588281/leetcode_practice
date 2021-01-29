package com.vincent.leetcode;

public class FindTheDuplicateNumber287 {

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        while (true) {
            fast = nums[fast];
            fast = nums[fast];
            slow = nums[slow];

            if (fast == slow) {
                break;
            }
        }
        slow = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast) {
                break;
            }
        }


        return slow;
    }
}
