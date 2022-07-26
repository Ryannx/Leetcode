package LC_629;

public class LC_629 {
    public int kInversePairs(int n, int k) {

        long[][] dp = new long[n + 1][k + 1];
        long base = (long) 1e9 + 7;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= i) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - i] + base) % base;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % base;
                }
            }
        }

        return (int) dp[n][k];
    }
}
