package LC_256;

import java.util.*;

public class LC_256 {
    public int minCost(int[][] costs) {

        // [red, blue, green]
        if (costs == null) {
            return 0;
        }

        int n = costs.length;
        int[][] dp = new int[n][3];
        for (int[] r : dp) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == k) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i][j]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        LC_256 lc_256 = new LC_256();
        System.out.println(lc_256.minCost(costs));
    }
}
