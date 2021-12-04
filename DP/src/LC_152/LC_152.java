package LC_152;

public class LC_152 {
    public int maxProduct(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] dp1 = new int[len]; // max
        int[] dp2 = new int[len]; // min
        dp1[0] = nums[0];
        dp2[0] = nums[0];
        int res = nums[0];

        for (int i = 1; i < len; i++) {
            dp1[i] = Math.max(Math.max(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i]), nums[i]);
            dp2[i] = Math.min(Math.min(dp1[i - 1] * nums[i], dp2[i - 1] * nums[i]), nums[i]);
            res = Math.max(res, dp1[i]);
        }

        return res;
    }
}
