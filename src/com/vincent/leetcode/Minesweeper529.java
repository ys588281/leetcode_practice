package com.vincent.leetcode;

public class Minesweeper529 {
    public static void main(String[] args) {

    }

    public static char[][] minesweeper(char[][] board, int[] click) {
        if (board == null || board.length == 0) {
            return board;
        }
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        if (board[click[0]][click[1]] == 'B') {
            return board;
        }
        helper(board, click[1], click[0]);
        return board;
    }

    private static void helper(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return;
        }
        if (board[x][y] == 'B' || board[x][y] == 'M') {
            return;
        }
        int mineNumber = 0;
        if (x > 0) {
            if (board[x -1][y] == 'M') mineNumber++;
        }
        if (y > 0) {
            if (board[x][y - 1] == 'M') mineNumber++;
        }
        if (x > 0 && y > 0) {
            if (board[x - 1][y - 1] == 'M') mineNumber++;
        }
        if (x > 0 || y < board.length - 1) {
            if (board[x - 1][y + 1] == 'M') mineNumber++;
        }
        if (x < board[0].length - 1)  {
            if (board[x + 1][y] == 'M') mineNumber++;
        }
        if (y < board[0].length - 1)  {
            if (board[x][y + 1] == 'M') mineNumber++;
        }
        if (x < board.length - 1 && y < board[0].length - 1)  {
            if (board[x + 1][y + 1] == 'M') mineNumber++;
        }
        if (x < board.length - 1 && y > 0)  {
            if (board[x + 1][y - 1] == 'M') mineNumber++;
        }
        if (mineNumber == 0) {
            board[x][y] = 'B';
        } else {
            board[x][y] = (char)(mineNumber+'0');
        }


        if (x > 0) {
            helper(board, x - 1, y);
        }
        if (y > 0) {
            helper(board, x, y - 1);
        }
        if (x > 0 && y > 0) {
            helper(board, x - 1, y - 1);
        }
        if (x > 0 || y < board.length - 1) {
            helper(board, x - 1, y + 1);
        }
        if (x < board[0].length - 1)  {
            helper(board, x + 1, y);
        }
        if (y < board[0].length - 1)  {
            helper(board, x, y + 1);
        }
        if (x < board.length - 1 && y < board[0].length - 1)  {
            helper(board, x + 1, y + 1);
        }
        if (x < board.length - 1 && y > 0)  {
            helper(board, x + 1, y - 1);
        }
    }
}
