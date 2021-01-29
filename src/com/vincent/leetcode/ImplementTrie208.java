package com.vincent.leetcode;


public class ImplementTrie208 {

    public static void main(String[] args) {

    }

    class Node {
        private char ch;
        private boolean isEnd;
        private Node[] children;

        public Node() {
        }

        public Node(char ch, boolean isEnd) {
            this.ch = ch;
            this.isEnd = isEnd;
        }
    }

    class Trie {
        private Node root;

        public Trie() {
            root = new Node(' ', false);
        }

        public void insert(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int idx = c - 'a';
                if (null == node.children[idx]) {
                    node.children[idx] = new Node(c, false);
                }
                node = node.children[idx];

                if (i == word.length() - 1) {
                    node.isEnd = true;
                }
            }
        }

        public boolean search(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
            }
            if (node.isEnd) {
                return true;
            }
            return false;
        }

        public boolean startWith(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
            }
            return true;
        }

    }
}
