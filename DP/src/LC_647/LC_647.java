package LC_647;

public class LC_647 {
    public int countSubstrings(String s) {

        if (s == null) {
            return 0;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int res = n;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i + 1 < n; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            res += dp[i][i + 1] ? 1 : 0;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                res += dp[i][j] ? 1 : 0;
            }
        }

        return res;
    }
}
