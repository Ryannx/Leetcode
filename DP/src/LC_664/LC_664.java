package LC_664;

import java.util.Arrays;

public class LC_664 {
    public int strangePrinter(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] c : dp) {
            Arrays.fill(c, Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = 1 + dp[i + 1][j];
                for (int k = i + 1; k < j; k++) {
                    if (s.charAt(i) == s.charAt(k)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k + 1][j]);
                    }
                }
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[0][n - 1];
    }
}
