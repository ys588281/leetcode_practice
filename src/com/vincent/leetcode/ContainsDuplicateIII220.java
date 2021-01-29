package com.vincent.leetcode;

import java.util.TreeSet;

public class ContainsDuplicateIII220 {

    public static void main(String[] args) {
//        System.out.println(containsDuplicateIII(new int[]{1,5,9,1,5,9}, 2, 3));
        System.out.println(containsDuplicateIII(new int[]{-1,2147483647}, 1, 2147483647));
    }

    public static boolean containsDuplicateIII(int[] nums, int k, int t) {
        if (k < 1) return false;

        TreeSet<Integer> tSet = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            Integer floor = tSet.floor(x);
            Integer ceiling = tSet.ceiling(x);
            if ((floor != null && x <= floor + t) || (ceiling != null && x >= ceiling - t)) {
                return true;
            }
            tSet.add(x);
            if (i >= k) {
                tSet.remove(nums[i - k]);
            }
        }
        return false;
    }
}
