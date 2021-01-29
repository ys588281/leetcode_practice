package com.vincent.leetcode;

public class CapacityToShipPackagesWithinDDays1011 {

    public static void main(String[] args) {
        System.out.println(capacityToShipPackagesWithinDDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));
        System.out.println(capacityToShipPackagesWithinDDays(new int[]{3,2,2,4,1,4}, 3));
        System.out.println(capacityToShipPackagesWithinDDays(new int[]{1,2,3,1,1}, 4));
    }


//    – 如果middays < D, 那就不符合要求，运力太少了，运力一定是需要增加， 那么一定是low=mid+1
//    – 如果middays == D, 那有可能当前的运力是答案， 因为可能运力减少1以后就不符合要求了， 所以这里设置high=mid
//    – 如果middays > D, 同样，这时候也应该设置high=mid, 因为运力减少1以后也有可能不符合要求
    public static int capacityToShipPackagesWithinDDays(int[] weights, int d) {
        if (d <= 0) return -1;
        if (weights == null || weights.length == 0) return 0;
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (helper(weights, middle) >= d) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    private static int helper(int[] weights, int k) {
        int total = 0;
        int temp = 0;
        for (int i = 0; i < weights.length; i++) {
            temp += weights[i];
            if (temp < k) continue;
            total++;
            if (temp == k) {
                temp = 0;
            } else {
                temp = weights[i];
            }
        }
        return total;
    }
}
