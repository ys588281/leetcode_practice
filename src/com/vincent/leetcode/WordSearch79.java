package com.vincent.leetcode;

public class WordSearch79 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(wordSearch(board, "ABCCED"));
        System.out.println(wordSearch(board, "SEE"));
        System.out.println(wordSearch(board, "ABCB"));
    }

    public static boolean wordSearch(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return true;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (wordSearchHelper(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean wordSearchHelper(char[][] board, String word, int idx, int i, int j, boolean[][] visited) {
        if (idx == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] == true || board[i][j] != word.charAt(idx)) {
            return false;
        }
        visited[i][j] = true;
        boolean res = wordSearchHelper(board, word, idx+1, i+1, j, visited)
                || wordSearchHelper(board, word, idx+1, i, j+1, visited)
                || wordSearchHelper(board, word, idx+1, i-1, j, visited)
                || wordSearchHelper(board, word, idx+1, i, j-1, visited);
        visited[i][j] = false;
        return res;
    }
}
