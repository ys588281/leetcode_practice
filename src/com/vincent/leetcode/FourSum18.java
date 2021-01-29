package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                helper(res, nums, left, right, nums[i], nums[j], target);
            }
        }
        return res;
    }

    private static void helper(List<List<Integer>> res, int[] nums, int left, int right, int current1, int current2, int target) {
        while (left < right) {
            int tempSum = nums[left] + nums[right] + current1 + current2;
            if (tempSum == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(current1);
                temp.add(current2);
                temp.add(nums[left]);
                temp.add(nums[right]);
                res.add(temp);
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                left++;
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                right--;
            } else if (tempSum > target) {
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }
                right--;
            } else {
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                left++;
            }
        }
    }
}
