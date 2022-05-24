package LC_32;

public class LC_32 {
    public int longestValidParentheses(String s) {

        if (s == null || s.length() < 2) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n];
        int res = 0;
        if (s.charAt(0) == '(' && s.charAt(1) == ')') {
            dp[1] = 2;
            res = 2;
        }
        for (int i = 2; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                    res = Math.max(res, dp[i]);
                } else { // ')'
                    int idx = i - dp[i - 1] - 1;
                    if (idx >= 0 && s.charAt(idx) == '(') {
                        dp[i] = i - idx + 1 + (idx - 1 >= 0 ? dp[idx - 1] : 0);
                        res = Math.max(res, dp[i]);
                    }
                }
            }
        }

        return res;
    }
}
