package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordBreak139 {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean res = wordBreak("leetcode", wordDict);
        System.out.println(res);

        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("cats");
        wordDict2.add("dog");
        wordDict2.add("sand");
        wordDict2.add("and");
        wordDict2.add("cat");
        boolean res2 = wordBreak("catsandog", wordDict2);
        System.out.println(res2);

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String temp = s.substring(j, i);
                if (dp[j] == true && wordDict.contains(temp)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
