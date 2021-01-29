package com.vincent.practice.sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] A = new int[]{12, 13, 24, 10, 3, 6, 90, 70};
        quickSort(A, 0, A.length - 1);
        for (int i : A) {
            System.out.println(i);
        }
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (right <= left) return;
        int pivotIndex = left + (right - left) / 2;
        int pivot = nums[pivotIndex];
        swap(nums, pivotIndex, right);

        int swapIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, swapIndex, i);
                swapIndex++;
            }
        }
        swap(nums, swapIndex, right);
        quickSort(nums, left, swapIndex - 1);
        quickSort(nums, swapIndex + 1, right);
    }

    public static void swap(int[] inputs, int i, int j) {
        int temp = inputs[i];
        inputs[i] = inputs[j];
        inputs[j] = temp;
    }
}
