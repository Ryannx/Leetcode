package LC_312;

public class LC_312 {
    public int maxCoins(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int inputLen = nums.length;
        // dp[i, j]: the maximum coins you can collect by bursting the balloons [i, j]
        // i - 1  [i, k - 1] k [k + 1, j]  j + 1
        int[][] dp = new int[inputLen + 2][inputLen + 2];
        int[] arr = new int[inputLen + 2];
        for (int i = 1; i <= inputLen; i++) {
            arr[i] = nums[i -1];
        }
        arr[0] = 1;
        arr[arr.length - 1] = 1;
        for (int len = 1; len <= inputLen; len++) {
            for (int i = 1; i + len - 1 <= inputLen; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j + 1]);
                }
            }
        }

        return dp[1][inputLen];
    }

    public static void main(String[] args) {
        LC_312 lc_312 = new LC_312();
        int[] nums = {3,1,5,8};
        System.out.println(lc_312.maxCoins(nums));
    }
}
