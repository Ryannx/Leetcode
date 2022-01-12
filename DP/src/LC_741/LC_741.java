package LC_741;

import java.util.Arrays;

public class LC_741 {
    public int cherryPickup(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;

        int[][][] dp = new int[n + 1][n + 1][n + 1]; // [i, j] [x, y]
        for (int[][] m : dp) {
            for (int[] arr : m) {
                Arrays.fill(arr, Integer.MIN_VALUE);
            }
        }
        dp[1][1][1] = grid[0][0];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int x = 1; x <= n; x++) {
                    int y = i + j - x;
                    if (y <= 0 || y > n) {
                        continue;
                    }
                    if (grid[i - 1][j - 1] == -1 || grid[x - 1][y - 1] == -1) {
                        continue;
                    }
                    if (i == x && j == y) {
                        dp[i][j][x] = Math.max(dp[i][j][x], dp[i - 1][j][x - 1] + grid[i - 1][j - 1]);
                        dp[i][j][x] = Math.max(dp[i][j][x], dp[i - 1][j][x] + grid[i - 1][j - 1]);
                        dp[i][j][x] = Math.max(dp[i][j][x], dp[i][j - 1][x - 1] + grid[i - 1][j - 1]);
                        dp[i][j][x] = Math.max(dp[i][j][x], dp[i][j - 1][x] + grid[i - 1][j - 1]);
                        continue;
                    }
                    dp[i][j][x] = Math.max(dp[i][j][x], dp[i - 1][j][x - 1] + grid[i - 1][j - 1] + grid[x - 1][y - 1]);
                    dp[i][j][x] = Math.max(dp[i][j][x], dp[i - 1][j][x] + grid[i - 1][j - 1] + grid[x - 1][y - 1]);
                    dp[i][j][x] = Math.max(dp[i][j][x], dp[i][j - 1][x - 1] + grid[i - 1][j - 1] + grid[x - 1][y - 1]);
                    dp[i][j][x] = Math.max(dp[i][j][x], dp[i][j - 1][x] + grid[i - 1][j - 1] + grid[x - 1][y - 1]);
                }
            }
        }

        return dp[n][n][n] < 0 ? 0 : dp[n][n][n];
    }

    public static void main(String[] args) {
        LC_741 lc_741 = new LC_741();
        int[][] grid = {{1,1,-1},{1,-1,1},{-1,1,1}};
        System.out.println(lc_741.cherryPickup(grid));
    }
}
