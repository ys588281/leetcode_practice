package com.vincent.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceWords648 {

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        System.out.println(replaceWords(dict, "the cattle was rattled by the battery"));
    }

    public static String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (int i = 0; i < dict.size(); i++) {
            trie.insert(dict.get(i));
        }
        StringBuilder sb = new StringBuilder();
        String[] split = sentence.split(" ");
        for (int i =0; i< split.length; i++) {
            sb.append(trie.getShortest(split[i]));
            if (i != split.length-1) {
                sb.append(" ");
            }
        }
        new String();
        return sb.toString();
    }

}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (null == node.children[idx]) {
                node.children[idx] = new TrieNode(c, false);
            }
            node = node.children[idx];
            if (i == word.length() - 1) {
                node.isEnd = true;
            }
        }
    }

    public String getShortest(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (node.children[idx] != null) {
                node = node.children[idx];
                if (node.isEnd) {
                    return word.substring(0, i+1);
                }
            }
        }
        return word;
    }
}

class TrieNode {
    char ch;
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        this.isEnd = false;
        this.ch = ' ';
        this.children = new TrieNode[26];
    }

    public TrieNode(char ch, boolean isEnd) {
        this.ch = ch;
        this.isEnd = isEnd;
        this.children = new TrieNode[26];
    }
}
