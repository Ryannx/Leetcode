package LC_739;

import java.util.Stack;

public class LC_739 {
    public int[] dailyTemperatures(int[] temperatures) {

        if (temperatures == null || temperatures.length == 0) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (temperatures[stack.peek()] >= temperatures[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return res;
    }
}
