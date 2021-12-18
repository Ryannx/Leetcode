package LC_51;

import java.util.*;

public class LC_51 {
//    public List<List<String>> solveNQueens(int n) {
//
//        char[][] board = new char[n][n];
//        for (int i = 0; i < n;i++) {
//            for (int j = 0; j < n; j++) {
//                board[i][j] = '.';
//            }
//        }
//    }
//
//    private void dfs(List<List<String>> res, char[][] board, int idx, int n) {
//
//        if (idx == n) {
//            res.add(getAnswer(board));
//            return;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (valid(board, idx, i, n)) {
//                board[idx][i] = 'Q';
//                dfs(res, board, idx + 1, n);
//                board[idx][i] = '.';
//            }
//        }
//    }
//
//    private boolean valid(char[][] board, int row, int col, int n) {
//
//        for (int i = 0; i < n; i++) {
//            if (board[i][col] == 'Q') {
//                return false;
//            }
//            if (board[row][i] == 'Q') {
//                return false;
//            }
//        }
//        int k = 1;
//        while (row - k >= 0 && col - 1 >= 0) {
//            if (board[row - k][col - k] )
//        }
//    }
}
