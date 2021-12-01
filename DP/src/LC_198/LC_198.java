package LC_198;

public class LC_198 {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], (i - 2 >= 0 ? dp[i - 2] : 0) + nums[i]);
        }

        return dp[len - 1];
    }

    public static void main(String[] args) {
        LC_198 lc_198 = new LC_198();
        int[] nums = {1,2,3,1};
        System.out.println(lc_198.rob(nums));
    }
}
