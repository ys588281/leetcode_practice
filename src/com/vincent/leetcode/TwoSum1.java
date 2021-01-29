package com.vincent.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public static void main(String[] args) {

    }

    public static int[] twoSum(int[] inputs, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i++) {
            int res = target - inputs[i];
            map.put(res, i);
        }

        for (int i = 0; i < inputs.length; i++) {
            if (map.containsKey(inputs[i])) {

            }
        }
        return new int[]{};
    }
}
