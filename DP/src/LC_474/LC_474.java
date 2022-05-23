package LC_474;

import java.util.Arrays;

public class LC_474 {
    public int findMaxForm(String[] strs, int m, int n) {

        if (strs == null) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int k = 0; k < strs.length; k++) {
            int[] zeroOne = count(strs[k]);
            int[][] temp = copyDP(dp);
            for (int i = zeroOne[0]; i <= m; i++) {
                for (int j = zeroOne[1]; j <= n; j++) {
                    dp[i][j] = Math.max(temp[i][j], temp[i - zeroOne[0]][j - zeroOne[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[][] copyDP(int[][] dp) {
        int[][] res = new int[dp.length][dp[0].length];
        for (int i = 0; i < dp.length; i++) {
            res[i] = Arrays.copyOf(dp[i], dp[i].length);
        }
        return res;
    }

    private int[] count(String str) {
        int[] res = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                res[0]++;
            } else {
                res[1]++;
            }
        }
        return res;
    }
}
