package LC_743.v3;

public class LC_743 {
    public int networkDelayTime(int[][] times, int n, int k) {

        if (times == null || times.length == 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }

        for (int[] edge : times) {
            dp[edge[0]][edge[1]] = edge[2];
        }
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 0;
        }
        for (int m = 1; m <= n; m++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m][j]);
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dp[k][i]);
        }

        return res == Integer.MAX_VALUE / 2 ? -1 : res;
    }
}
