package LC_2281;

import java.util.Arrays;
import java.util.Stack;

public class LC_2281 {
    public int totalStrength(int[] strength) {
        if (strength == null) {
            return 0;
        }

        int M = (int) 1e9 + 7;
        int[] nums = update(strength);
        int n = strength.length;
        int[] nextSmaller = new int[n + 2];
        Arrays.fill(nextSmaller, n + 1);
        int[] prevSmallerOrEqual = new int[n + 2];
        Stack<Integer> increasing = new Stack<>();
        for (int i = 1; i <= n; i++) {
            while (!increasing.isEmpty() && nums[increasing.peek()] > nums[i]) {
                nextSmaller[increasing.pop()] = i;
            }
            if (!increasing.isEmpty()) {
                prevSmallerOrEqual[i] = increasing.peek();
            }
            increasing.push(i);
        }
        // preSum
        long[] preSum = new long[n + 1];
        long[] preSum2 = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = (preSum[i - 1] + nums[i]) % M;
            preSum2[i] = (preSum2[i - 1] + (long) nums[i] * i % M) % M;
        }

        long res = 0;
        for (int i = 1; i <= n; i++) {
            int a = prevSmallerOrEqual[i];
            int b = nextSmaller[i];
            int x = i - a;
            int y = b - i;
            long left = (preSum2[i - 1] - preSum2[a] - (preSum[i - 1] - preSum[a]) * (long) a % M + M) % M;
            left = left * y % M;
            long right = ((preSum[b - 1] - preSum[i]) * (long) b % M - (preSum2[b - 1] - preSum2[i]) + M) % M;
            right = right * x % M;
            long mid = (long) nums[i] * x % M * y % M;
            res += (left + right + mid) % M * nums[i] % M;
            res %= M;
        }

        return (int) res;
    }

    private int[] update(int[] strength) {
        int[] nums = new int[strength.length + 1];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = strength[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        LC_2281 lc_2281 = new LC_2281();
        int[] nums = {1,2,3};
        System.out.println(lc_2281.totalStrength(nums));
    }
}
