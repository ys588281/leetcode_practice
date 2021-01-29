package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight406 {
    public static void main(String[] args) {
        int[][] results = queueReconstructionByHeight(new int[][]{
                {9, 0},
                {7, 4},
                {1, 9},
                {3, 0},
                {2, 7},
                {5, 3},
                {6, 0},
                {3, 4},
                {6, 2},
                {5, 2}
        });
//        for (int[] res : results) {
//            System.out.println(res[0] + " " + res[1]);
//        }
    }

    public static int[][] queueReconstructionByHeight(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        List<int[]> linkedList = new LinkedList<>();

        for (int[] person : people) {
            linkedList.add(person[1], person);
        }
        return linkedList.toArray(new int[linkedList.size()][]);
    }
}
