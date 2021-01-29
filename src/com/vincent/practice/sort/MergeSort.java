package com.vincent.practice.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {9, 6, 4, 6, 3, 1, 8, 7, 13, 19};
        System.out.println("排序前的数组如下：" + Arrays.toString(a));
        mergeSort(a, 0, a.length - 1);
        System.out.println("排序后的数组如下：" + Arrays.toString(a));

    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right ) {
        // 記得長度計算邊界
        int l1 = middle - left + 1;
        int l2 = right - middle;
        int[] arr1 = new int[l1];
        int[] arr2 = new int[l2];

        for (int i = 0; i < l1; i++) {
            arr1[i] = arr[left + i];
        }

        for (int i = 0; i < l2; i++) {
            // 記得計算middle後面的index + 1
            arr2[i] = arr[middle + i + 1];
        }

        int i = 0, j = 0, k = left;

        while (i < l1 && j < l2) {
            int n1 = arr1[i];
            int n2 = arr2[j];
            if (n1 < n2) {
                arr[k] = n1;
                i++;
                k++;
            } else {
                arr[k] = n2;
                j++;
                k++;
            }
        }

        while (i < l1) {
            int n1 = arr1[i];
            arr[k] = n1;
            i++;
            k++;
        }

        while (j < l2) {
            int n2 = arr2[j];
            arr[k] = n2;
            j++;
            k++;
        }

    }
}
