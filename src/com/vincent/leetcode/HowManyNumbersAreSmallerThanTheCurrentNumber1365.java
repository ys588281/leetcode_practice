package com.vincent.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HowManyNumbersAreSmallerThanTheCurrentNumber1365 {

    public static void main(String[] args) {
        int[] results = howManyNumbersAreSmallerThanTheCurrentNumber(new int[]{8,1,2,2,3});
        for (int res : results) {
            System.out.println(res);
        }
    }

    public static int[] howManyNumbersAreSmallerThanTheCurrentNumber(int[] nums) {
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i];
        }
        Arrays.sort(nums2);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (i > 0) {
                if (map.containsKey(nums2[i])) {
                    continue;
                }
                map.put(nums2[i], i);
            } else {
                map.put(nums2[i], i);
            }
        }
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            results[i] = map.get(nums[i]);
        }
        return results;
    }
}
