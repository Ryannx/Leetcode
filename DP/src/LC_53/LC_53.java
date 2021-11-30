package LC_53;

public class LC_53 {

    public int maxSubArray(int[] nums) {

        if (nums == null) {
            return 0;
        }

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
