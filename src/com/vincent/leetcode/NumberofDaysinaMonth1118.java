package com.vincent.leetcode;

public class NumberofDaysinaMonth1118 {

    public static void main(String[] args) {
        System.out.println(numberofDaysinaMonth(1992, 7));
        System.out.println(numberofDaysinaMonth(2000, 2));
        System.out.println(numberofDaysinaMonth(1900, 2));
    }

    public static int numberofDaysinaMonth(int year, int month) {
        switch (month) {
            case 1:
                return 31;
            case 2: {
                if (year % 4 == 0 && year % 100 != 0) {
                    return 29;
                }
                if (year % 400 == 0) {
                    return 29;
                }
                return 28;
            }
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;
        }
    }

}
