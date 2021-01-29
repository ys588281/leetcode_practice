package com.vincent.leetcode;

public class MissingNumber268 {

    public static void main(String[] args) {
        int[] inputs = new int[]{9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(inputs));
        System.out.println(missingNumberCycleSort(inputs));
        inputs = new int[]{3, 0, 1};
        System.out.println(missingNumber(inputs));
        System.out.println(missingNumberCycleSort(inputs));
    }

    public static int missingNumber(int[] inputs) {
        int res = 0, i = 0;
        for (i = 0; i < inputs.length; i++) {
            res = res ^ i;
            res = res ^ inputs[i];
        }
        res = res ^ i;
        return res;
    }

    public static int missingNumberCycleSort(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            int j = nums[i];
            if (j < n && nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (k != nums[k]) {
                return k;
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
