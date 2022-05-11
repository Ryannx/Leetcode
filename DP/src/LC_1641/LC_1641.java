package LC_1641;

public class LC_1641 {
    public int countVowelStrings(int n) {

        // dp[i][j]: idx:i fill jth char
        int[][] dp = new int[n][5];
        for (int j = 0; j < 5; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = j; k >= 0; k--) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        int res = 0;
        for (int j = 0; j < 5; j++) {
            res += dp[n - 1][j];
        }

        return res;
    }
}
