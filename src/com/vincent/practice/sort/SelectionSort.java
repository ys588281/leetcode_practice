package com.vincent.practice.sort;

public class SelectionSort {

    public static void main(String[] args) {
        int[] A = new int[]{12, 13, 24, 10, 3, 6, 90, 70};
        selectionSort(A);
        for (int i : A) {
            System.out.println(i);
        }
    }

    public static void selectionSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int idx = i;
            for (int j = i; j < len; j++) {
                if (nums[j] < nums[idx]) {
                    idx = j;
                }
            }
            if (idx != i) {
                swap(nums, i, idx);
            }
        }
    }

    public static void swap(int[] inputs, int i, int j) {
        int temp = inputs[i];
        inputs[i] = inputs[j];
        inputs[j] = temp;
    }
}
