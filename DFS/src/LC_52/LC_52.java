package LC_52;

public class LC_52 {
    public int totalNQueens(int n) {

        // 1 represent Queen
        int[][] board = new int[n][n];

        int[] res = new int[1];
        dfs(board, 0, n, res);
        return res[0];
    }

    private void dfs(int[][] board, int idx, int n, int[] res) {

        if (idx == n) {
            res[0]++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (valid(board, idx, i, n)) {
                board[idx][i] = 1;
                dfs(board, idx + 1, n, res);
                board[idx][i] = 0;
            }
        }
    }

    private boolean valid(int[][] board, int row, int col, int n) {

        for (int i = 0; i < n; i++) {
            if (board[i][col] == 1) {
                return false;
            }
            if (board[row][i] == 1) {
                return false;
            }
        }

        int k = 1;
        while (row - k >= 0 && col - k >= 0) {
            if (board[row - k][col - k] == 1) {
                return false;
            }
            k++;
        }
        k = 1;
        while (row - k >= 0 && col + k < n) {
            if (board[row - k][col + k] == 1) {
                return false;
            }
            k++;
        }

        return true;
    }

    public static void main(String[] args) {
        LC_52 lc_52 = new LC_52();
        System.out.println(lc_52.totalNQueens(4));
    }
}
