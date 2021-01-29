package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            helper(res, nums, left, right, nums[i]);
        }
        return res;
    }

    private static void helper(List<List<Integer>> res, int[] nums, int left, int right, int target) {
        while (left < right) {
            if (nums[left] + nums[right] + target == 0) {
                List<Integer> subRes = new ArrayList<>();
                subRes.add(target);
                subRes.add(nums[left]);
                subRes.add(nums[right]);
                res.add(subRes);
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                left++;
                right--;
            }
            if (nums[left] + nums[right] + target > 0) {
                while (left < right && nums[right] == nums[right - 1]) right--;
                right--;
            }
            if (nums[left] + nums[right] + target < 0) {
                while (left < right && nums[left] == nums[left + 1]) left++;
                left++;
            }
        }
    }
}
