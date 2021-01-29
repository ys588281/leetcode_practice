package com.vincent.leetcode;

public class DesignTicTacToe348 {

    public static void main(String[] args) {

    }


}

class TicTacToe2 {
    int n;
    int[] rows;
    int[] cols;
    int diag;
    int antiDiag;

    public TicTacToe2(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.diag = 0;
        this.antiDiag = 0;
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int point = (player == 1) ? 1 : -1;
        rows[row] += point;
        cols[col] += point;
        if (row == col) diag += point;
        if (row + col == n - 1) antiDiag += point;

        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n) {
            return player;
        }
        return 0;
    }
}

class TicTacToe {

    int[][] grid;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.grid = new int[n][n];
        this.n = n;
    }

    public boolean check(int row, int col, int player) {
        boolean hori = true, verticle  = true, diag1  = true, diag2 = true;
        for (int i = 0; i < grid[0].length - 1; i++) {
            if (grid[row][i] != grid[row][i + 1]) {
                hori = false;
                break;
            }
        }

        for (int i = 0; i < grid.length - 1; i++) {
            if (grid[i][col] != grid[i + 1][col]) {
                verticle = false;
                break;
            }
        }

        for (int i = 0; i < grid.length - 1; i++) {
            if (grid[i][col] != grid[i + 1][col]) {
                verticle = false;
                break;
            }
        }

        if (row == col) {
            for (int i = 0; i < grid.length - 1; i++) {
                if (grid[i][i] != grid[i + 1][i + 1]) {
                    diag1 = false;
                    break;
                }
            }
        } else {
            diag1 = false;
        }

        if (row + col == n - 1) {
            for (int i = 0; i < n - 1; i++) {
                if (grid[i][n - 1 - i] != grid[i + 1][n - 2 - i]) {
                    diag2 = false;
                    break;
                }
            }
        } else {
            diag2 = false;
        }

        if (hori || verticle || diag1 || diag2) return true;
        return false;

    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        this.grid[row][col] = player;
        if (check(row, col, n)) return player;
        return 0;
    }
}
