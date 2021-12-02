package LC_503;

import java.util.HashMap;
import java.util.Stack;

public class LC_503 {
    public int[] nextGreaterElements(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> nextGreater = new HashMap<>();

        for (int i = 0; i < len * 2; i++) {
            if (stack.isEmpty()) {
                stack.push(i % len);
            } else if (nums[stack.peek()] >= nums[i % len]) {
                stack.push(i % len);
            } else {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                    nextGreater.put(stack.pop(), i % len);
                }
                stack.push(i % len);
            }
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int temp = nextGreater.getOrDefault(i, -1);
            res[i] = temp == -1 ? -1 : nums[temp];
        }

        return res;
    }

    public static void main(String[] args) {
        LC_503 lc_503 = new LC_503();
        int[] nums = {1,2,1};
        int[] res = lc_503.nextGreaterElements(nums);
        for (int n : res) {
            System.out.println(n);
        }
    }
}
