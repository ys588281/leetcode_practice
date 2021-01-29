package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII229 {

    public static void main(String[] args) {
        int[] results = majorityElement(new int[]{3,2,3});
        for (int res : results) {
            System.out.print(res + "  ");
        }
        System.out.println("----");
        results = majorityElement(new int[]{1,1,1,3,3,2,2,2});
        for (int res : results) {
            System.out.print(res + "  ");
        }
    }

    public static int[] majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new int[]{nums[0]};
        }
        int m1 = nums[0], m2 = 0, count1 = 1, count2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == m1) {
                count1++;
            } else if (num == m2) {
                count2++;
            } else if (count1 == 0) {
                m1 = num;
                count1 = 0;
            } else if (count2 == 0) {
                m2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == m1) {
                count1++;
            }
            if (num == m2) {
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) {
            res.add(m1);
        }
        if (count2 > nums.length / 3) {
            res.add(m2);
        }
        int[] results = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            results[i] = res.get(i);
        }
        return results;
    }
}
