package LC_576;

public class LC_576 {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        long[][] dp = new long[m][n];
        long[][] temp = new long[m][n];
        long base = (long) 1e9 + 7;
        for (int k = 0; k < maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    long u = (i - 1 < 0) ? 1 : dp[i - 1][j];
                    long d = (i + 1 >= m) ? 1 : dp[i + 1][j];
                    long l = (j - 1 < 0) ? 1 : dp[i][j - 1];
                    long r = (j + 1 >= n) ? 1 : dp[i][j + 1];
                    temp[i][j] = (u + d + l + r) % base;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0;j < n; j++) {
                    dp[i][j] = temp[i][j];
                }
            }
        }
        return (int) dp[startRow][startColumn];
    }
}
