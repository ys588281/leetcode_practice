package com.vincent.practice;

public class Test {

    public static void main(String[] args) {
        System.out.println((int)(Math.random() * 10 % 1));
        int a  = 0;
        int b = 1;
        int t = 5 & 6 & 7;
        System.out.println(t);
        StringBuilder sb = new StringBuilder("ffefefwfefwv");
        char c = 'a';
        System.out.println((int) c);
        char temp = (char) (1 + sb.charAt(0) - 'a' + 97);
        System.out.println(temp);
        sb.deleteCharAt(0);
    }
}