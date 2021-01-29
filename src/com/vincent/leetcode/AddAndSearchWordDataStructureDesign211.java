package com.vincent.leetcode;

public class AddAndSearchWordDataStructureDesign211 {

    public static void main(String[] args) {

    }
}

class Trie211 {
    private TrieNode211 root;

    public Trie211() {
        this.root = new TrieNode211();
    }

    public void insert(String word) {
        TrieNode211 node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (null == node.children[idx]) {
                node.children[idx] = new TrieNode211(c, false);
            }
            node = node.children[idx];

            if (i == word.length() - 1) {
                node.isEnd = true;
            }
        }
    }

    public boolean search(String word) {
        return search(word, root, 0);
    }

    private boolean search(String word, TrieNode211 current, int start) {
        for (int i = start; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (c == '.') {
                for (int j = 0; j < current.children.length; j++) {
                    TrieNode211 temp = current.children[j];
                    if (null != temp) {
                        if (search(word, temp, start + 1)) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                if (null == current.children[idx]) {
                    return false;
                }
                current = current.children[idx];
            }
        }
        return current.isEnd;
    }
}

class TrieNode211 {
    char ch;
    boolean isEnd;
    TrieNode211[] children;

    public TrieNode211() {
        this.ch = ' ';
        this.isEnd = false;
        this.children = new TrieNode211[26];
    }

    public TrieNode211(char ch, boolean isEnd) {
        this.ch = ch;
        this.isEnd = isEnd;
    }
}
