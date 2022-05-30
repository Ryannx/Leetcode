package LC_2289;

import java.util.Stack;

public class LC_2289 {
    public int totalSteps(int[] nums) {

        if (nums == null) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                dp[i] = Math.max(dp[i] + 1, dp[stack.pop()]);
                res = Math.max(res, dp[i]);
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        LC_2289 lc_2289 = new LC_2289();
        int[] nums = {10, 1, 2, 9, 1, 2, 3, 4};
        System.out.println(lc_2289.totalSteps(nums));
    }
}
