package com.vincent.practice.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] a = {9, 6, 4, 6, 3, 1, 8, 7, 13, 19};
        System.out.println("排序前的数组如下：" + Arrays.toString(a));
        heapSort(a);
        System.out.println("排序后的数组如下：" + Arrays.toString(a));
    }

    public static void heapSort(int[] arr) {
        heapify(arr);
        int size = arr.length - 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            size = size - 1;
            maxHeap(arr, 0, size);
        }
    }

    public static void heapify(int[] arr) {
        int size = arr.length - 1;
        int parent = size / 2;
        for (int i = parent; i >= 0; i--) {
            maxHeap(arr, i, size);
        }
    }

    public static void maxHeap(int[] arr, int index, int end) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        if (left < end && arr[largest] < arr[left]) {
            largest = left;
        }

        if (left < end && arr[largest] < arr[right]) {
            largest = right;
        }

        if (largest != index) {
            swap(arr, largest, index);
            maxHeap(arr, largest, end);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }

}
