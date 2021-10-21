package LC_132;

public class LC_132 {
    public int minCut(String s) {

        if (s == null) {
            return 0;
        }

        int strLen = s.length();
        int[] dp = new int[strLen + 1];
        boolean[][] isPA = new boolean[strLen + 1][strLen + 1];
         // [i, j] [j + 1, strLen)
        for (int i = strLen - 1; i >= 0; i--) {
            dp[i] = strLen - i;
            for (int j = i; j < strLen; j++) {
                if (i == j || (i + 1 == j && s.charAt(i) == s.charAt(j)) || (s.charAt(i) == s.charAt(j) && isPA[i + 1][j - 1])) {
                    isPA[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }

        return dp[0] - 1;
    }

    public static void main(String[] args) {
        LC_132 lc_132 = new LC_132();
        String s = "aab";
        System.out.println(lc_132.minCut(s));
    }
}
