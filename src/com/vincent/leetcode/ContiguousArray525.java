package com.vincent.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray525 {
    public static void main(String[] args) {
        System.out.println(contiguousArray(new int[]{0, 1}));
        System.out.println(contiguousArray(new int[]{0, 1, 0}));
    }

    public static int contiguousArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count += -1;
            } else {
                count += 1;
            }

            if (map.containsKey(count)) {
                result = Math.max(result, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return result;
    }
}
