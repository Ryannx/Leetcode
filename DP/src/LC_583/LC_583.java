package LC_583;

import java.util.*;

public class LC_583 {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        String str1 = "#" + word1;
        String str2 = "#" + word2;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] r : dp) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
