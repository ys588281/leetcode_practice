package com.vincent.leetcode;

import java.util.Arrays;

public class WiggleSort280 {
    public static  void main(String[] args){
        int[] nums = new int[]{3, 5, 2, 1, 6, 4};
        wiggleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " , ");
        }
    }

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int i = 1;
        while (i < nums.length) {
            if (i + 1 >= nums.length) break;
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
            i += 2;
        }
    }
}
