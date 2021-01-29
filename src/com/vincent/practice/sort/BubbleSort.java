package com.vincent.practice.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A = new int[]{5,2,8,3,1,6,7,9};
        bubbleSort(A);
//        for (int i : A) {
//            System.out.println(i);
//        }
    }

    public static void bubbleSort(int[] inputs) {
        int len = inputs.length;
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (inputs[j] > inputs[j + 1]) {
                    count++;
                    System.out.println(inputs[j] + " " + inputs[j + 1]);
                    swap(inputs, j + 1, j);
                }
            }
        }
        System.out.println(count);
    }

    public static void swap(int[] inputs, int i, int j) {
        int temp = inputs[i];
        inputs[i] = inputs[j];
        inputs[j] = temp;
    }
}
