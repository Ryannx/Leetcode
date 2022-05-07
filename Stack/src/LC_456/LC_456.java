package LC_456;

import java.util.Stack;

public class LC_456 {
    public boolean find132pattern(int[] nums) {

        if (nums == null || nums.length < 3) {
            return false;
        }

        int[] leftMin = new int[nums.length];
        leftMin[0] = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i - 1]);
        }

        // find biggest smaller element idx > j
        Stack<Integer> stack = new Stack<>();
        int second = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(nums[i]);
                continue;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                second = stack.pop();
            }
            if (second > leftMin[i]) {
                return true;
            }
            stack.push(nums[i]);
        }

        return false;
    }
}
