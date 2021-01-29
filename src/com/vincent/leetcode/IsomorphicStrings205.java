package com.vincent.leetcode;

public class IsomorphicStrings205 {
    public static void main(String[] args) {
        System.out.println(isomorphicStrings("foo", "bar"));
        System.out.println(isomorphicStrings("egg", "add"));
        System.out.println(isomorphicStrings("paper", "title"));
    }

    public static boolean isomorphicStrings(String s, String t) {
        int length = s.length();
        int[] ss = new int[256];
        int[] ts = new int[256];
        for (int i = 0; i < length; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if (ss[cs - 'a'] == ts[ct - 'a']) {
                ss[cs - 'a'] = ss[cs - 'a'] + 1;
                ts[ct - 'a'] = ts[ct - 'a'] + 1;
            } else {
                return false;
            }
        }
        return true;
    }
}
