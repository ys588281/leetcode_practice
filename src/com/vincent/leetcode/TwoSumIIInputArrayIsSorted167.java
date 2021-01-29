package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIIInputArrayIsSorted167 {

    public static void main(String[] args) {
        System.out.println(twoSumIIInputArrayIsSorted(new int[]{2,7,11,15}, 9));
    }

    public static List<Integer> twoSumIIInputArrayIsSorted(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        List<Integer> res = new ArrayList<>();
        while (left < right) {
            int current = nums[left] + nums[right];
            if (current < target) {
                left++;
            }

            if (current > target) {
                right--;
            }

            if (current == target) {
                res.add(left + 1);
                res.add(right + 1);
                break;
            }
        }
        return res;
    }

}
