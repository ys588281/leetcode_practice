package com.vincent.leetcode;

import java.util.LinkedList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray448 {
    public static void main(String[] args) {
        int[] results = findAllNumbersDisappearedInAnArray(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }

    public static int[] findAllNumbersDisappearedInAnArray(int[] nums) {
        int i = 0, n = nums.length;
        while (i < n) {
            int j = nums[i];
            if (j < n && nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        List<Integer> res = new LinkedList<>();
        for (int k = 0; k < nums.length; k++) {
            if (k != nums[k]) {
                res.add(k);
            }
        }
        int[] results = new int[res.size()];
        for (int k = 0; k < res.size(); k++) {
            results[k] = res.get(k);
        }
        return results;
    }


    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
