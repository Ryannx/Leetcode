package LC_10;

public class LC_10 {
    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        String ss = "#" + s;
        String pp = "#" + p;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int j = 2; j <= n; j+=2) {
            dp[0][j] = pp.charAt(j) == '*' && dp[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (pp.charAt(j) >= 'a' && pp.charAt(j) <= 'z') {
                    dp[i][j] = dp[i - 1][j - 1] && ss.charAt(i) == pp.charAt(j);
                } else if (pp.charAt(j) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else { // *
                    boolean zero = dp[i][j - 2];
                    boolean noZero = (ss.charAt(i) == pp.charAt(j - 1) || pp.charAt(j - 1) == '.') &&
                            dp[i - 1][j];
                    dp[i][j] = zero || noZero;
                }
            }
        }

        return dp[m][n];
    }
}
