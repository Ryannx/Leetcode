package LC_1473.v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC_1473 {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {

        // [house, neighbor, color]
        int[][][] dp = new int[m + 1][target + 1][n + 1];

        int[] newHouses = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            newHouses[i] = houses[i - 1];
        }
        int[][] newCost = new int[m + 1][n];
        newCost[0] = new int[n];
        for (int i = 1; i <= m; i++) {
            newCost[i] = cost[i - 1];
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= target; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE / 2;
                }
            }
        }

        for (int k = 1; k <= n; k++) {
            dp[0][0][k] = 0;
        }

        Comparator<int[]> comparator = (a, b) -> (a[0] - b[0]);
        for (int i = 1; i <= m; i++) {
            if (newHouses[i] == 0) {
                for (int j = 1; j <= target; j++) {
                    List<int[]> list = new ArrayList<>();
                    for (int kk = 1; kk <= n; kk++) {
                        list.add(new int[] {dp[i - 1][j - 1][kk], kk});
                    }
                    Collections.sort(list, comparator);

                    for (int k = 1; k <= n; k++) {
                        // paint same color
                        dp[i][j][k] = dp[i - 1][j][k] + newCost[i][k - 1];
                        // paint different color
                        if (list.get(0)[1] != k) {
                            dp[i][j][k] = Math.min(dp[i][j][k], list.get(0)[0] + newCost[i][k - 1]);
                        } else {
                            dp[i][j][k] = Math.min(dp[i][j][k], list.get(1)[0] + newCost[i][k - 1]);
                        }
                    }
                }
            } else {
                for (int j = 1; j <= target; j++) {
                    int k = newHouses[i];
                    for (int kk = 1; kk <= n; kk ++) {
                        if (kk == k) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][kk]);
                        } else {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - 1][kk]);
                        }
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE / 2;
        for (int k = 1; k <= n; k++) {
            res = Math.min(res, dp[m][target][k]);
        }

        return res == Integer.MAX_VALUE / 2 ? -1 : res;
    }
}
