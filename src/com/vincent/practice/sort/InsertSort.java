package com.vincent.practice.sort;

public class InsertSort {

    public static void main(String[] args) {
        int[] A = new int[]{12, 13, 24, 10, 3, 6, 90, 70};
        insertSort(A);
        for (int i : A) {
            System.out.println(i);
        }
    }

    public static void insertSort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] inputs, int i, int j) {
        int temp = inputs[i];
        inputs[i] = inputs[j];
        inputs[j] = temp;
    }
}
