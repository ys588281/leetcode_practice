package com.vincent.leetcode;

import java.util.LinkedList;
import java.util.List;

public class FindAllDuplicatesinanArray442 {

    public static void main(String[] args) {
        int[] inputs = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> res = findAllDuplicatesinanArray(inputs);
        for (int r : res) {
            System.out.println(r);
        }
    }

    public static List findAllDuplicatesinanArray(int[] inputs) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[Math.abs(inputs[i]) - 1] < 0) {
                res.add(Math.abs(inputs[i]));
            }
            inputs[Math.abs(inputs[i]) - 1] *= -1;
        }
        return res;
    }
}
