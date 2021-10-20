package LC_72;

public class LC_72 {
    public int minDistance(String word1, String word2) {

        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException();
        }

        Integer[][] memo = new Integer[word1.length() + 1][word2.length() + 1];
        return dfs(word1, 0, word2, 0, memo);
    }

    // consider "replace" "remove" "add"          "keep"
    // the minDistance word1[idx1, word1Len] -> word2[idx2, word2Len]
    private int dfs(String word1, int idx1, String word2, int idx2, Integer[][] memo) {

        int word1Len = word1.length();
        int word2Len = word2.length();

        if (memo[idx1][idx2] != null) {
            return memo[idx1][idx2];
        }

        if (idx1 == word1Len) {
            memo[idx1][idx2] = word2Len - idx2;
            return word2Len - idx2;
        }
        if (idx2 == word2Len) {
            memo[idx1][idx2] = word1Len - idx1;
            return word1Len - idx1;
        }



        int res = Integer.MAX_VALUE;
        char ch1 = word1.charAt(idx1);
        char ch2 = word2.charAt(idx2);
        if (ch1 == ch2) {
            int val = dfs(word1, idx1 + 1, word2, idx2 + 1, memo);
            memo[idx1][idx2] = val;
            return Math.min(res, val);
        }

        // replace
        res = Math.min(res, dfs(word1, idx1 + 1, word2, idx2 + 1, memo) + 1);
        // remove
        res = Math.min(res, dfs(word1, idx1 + 1, word2, idx2, memo) + 1);
        // add
        res = Math.min(res, dfs(word1, idx1, word2, idx2 + 1, memo) + 1);
        memo[idx1][idx2] = res;
        return res;
    }

    public static void main(String[] args) {
        LC_72 lc_72 = new LC_72();
        String word1 = "sea";
        String word2 = "eat";
        System.out.println(lc_72.minDistance(word1, word2));
    }
}
