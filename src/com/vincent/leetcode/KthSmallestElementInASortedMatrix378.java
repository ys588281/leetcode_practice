package com.vincent.leetcode;

public class KthSmallestElementInASortedMatrix378 {

    public static void main(String[] args) {
        System.out.println(kthSmallestElementInASortedMatrix(
                new int[][]{
                        {1,  5,  9},
                        {10, 11, 13},
                        {12, 13, 15}
                }, 8));
    }

    public static int kthSmallestElementInASortedMatrix(int[][] matrix, int k) {
        int left = matrix[0][0], right = matrix[matrix.length - 1][matrix[0].length - 1];
        while (left < right) {
            int middle = left + (right - left) / 2;
            int count = countSmallerItem(matrix, middle);
            if (count >= k) {
                right = middle;
            }
            else {
                left = middle + 1;
            }
        }
        return right;
    }

    private static int countSmallerItem(int[][] matrix, int target) {
        int count = 0;
       for (int i = 0; i < matrix.length; i++) {
           int j = matrix[0].length - 1;
           while (j >= 0) {
               if (matrix[i][j] > target) j--;
               else break;
           }
           count += (j + 1);
       }
       return count;
    }
}
