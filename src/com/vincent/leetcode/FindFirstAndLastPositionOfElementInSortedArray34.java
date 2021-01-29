package com.vincent.leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray34 {

    public static void main(String[] args) {
        int[] results = findFirstAndLastPositionOfElementInSortedArray(new int[]{5,7,7,8,8,10}, 8);
        System.out.println(results[0]);
        System.out.println(results[1]);
    }

    public static int[] findFirstAndLastPositionOfElementInSortedArray(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return null;
            }
        }
        int idx = binarySearch(nums, target, 0, nums.length - 1);
        int[] results = new int[2];
        for (int i = idx; i >= 0; i--) {
            if (nums[i] != target) {
                results[0] = i+1;
                break;
            }
        }
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] != target) {
                results[1] = i-1;
                break;
            }
        }
        return results;
    }

    private static int binarySearch(int[] nums, int target, int start, int end) {
        int middle = (start + end) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] > target) {
            return binarySearch(nums, target, start, middle - 1);
        } else {
            return binarySearch(nums, target, middle, end);
        }
    }
}
