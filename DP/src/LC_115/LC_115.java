package LC_115;

public class LC_115 {
    public int numDistinct(String s, String t) {


        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }

        // dp[i][j]: the number of distinct subsequences of ss[1:i] which equals tt[1:j]
        int sLen = s.length();
        int tLen = t.length();
        String ss = "#" + s;
        String tt = "#" + t;

        // X X X X X X i
        // Y Y Y j
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (ss.charAt(i) == tt.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[sLen][tLen];
    }

    public static void main(String[] args) {
        LC_115 lc_115 = new LC_115();
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(lc_115.numDistinct(s, t));
    }
}
