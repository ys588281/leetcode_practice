package com.vincent.leetcode;

public class SearchA2dMatrix74 {

    public static void main(String[] args) {
        System.out.println(
                searchA2dMatrix(new int[][]{
                        {1,   3,  5,  7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}
                }, 3)
        );
        System.out.println(
                searchA2dMatrix(new int[][]{
                        {1,   3,  5,  7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 50}
                }, 13)
        );
    }

    public static boolean searchA2dMatrix(int[][] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int startRow = 0, endRow = nums.length - 1;
        int rowLeng = nums[0].length;
        while (startRow < endRow) {
            int middle = startRow + (endRow - startRow) / 2;
            if (nums[middle][rowLeng - 1] == target) return true;
            if (nums[middle][rowLeng - 1] > target) {
                endRow = middle;
            } else {
                startRow = middle + 1;
            }
        }

        int startCol = 0, endCol = rowLeng - 1;
        while (startCol < endCol) {
            int middle = startCol + (endCol - startCol) / 2;
            if (nums[startRow][middle] == target) return true;
            if (nums[startRow][middle] > target) {
                endCol = middle;
            } else {
                startCol = middle + 1;
            }
        }
        return false;
    }
}
