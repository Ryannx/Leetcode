package LC_96;

public class LC_96 {
    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                dp[i] += (dp[k - 1] * dp[i - k]);
            }
        }

        return dp[n];
    }
}
