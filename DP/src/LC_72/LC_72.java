package LC_72;

public class LC_72 {

    public int minDistance(String word1, String word2) {

        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException();
        }

        // if (word1[i] == word2[j]) dp[i][j] = dp[i + 1][j + 1];
        // else dp[i][j] = min(dp[i + 1][j + 1] + 1, dp[i][j + 1] + 1, dp[i + 1][j] + 1);
        // the minDistance word1[idx1, word1Len] -> word2[idx2, word2Len]
        int word1Len = word1.length();
        int word2Len = word2.length();
        int[][] dp = new int[word1Len + 1][word2Len + 1];
        for (int j = word2Len; j >= 0; j--) {
            dp[word1Len][j] = word2Len - j;
        }
        for (int i = word1Len; i >= 0; i--) {
            dp[i][word2Len] = word1Len - i;
        }

        for (int i = word1Len - 1; i >= 0; i--) {
            for (int j = word2Len - 1; j >= 0; j--) {
                dp[i][j] = Integer.MAX_VALUE;
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j + 1] + 1, Math.min(dp[i][j + 1] + 1, dp[i + 1][j] + 1));
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        LC_72 lc_72 = new LC_72();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(lc_72.minDistance(word1, word2));
    }
}
