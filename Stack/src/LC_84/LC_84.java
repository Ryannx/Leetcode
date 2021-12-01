package LC_84;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_84 {
    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < heights.length; i++) {
            list.add(heights[i]);
        }
        list.add(0);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(stack.peek())) {
                stack.push(i);
            } else {
                while (list.get(stack.peek()) > list.get(i)) {
                    int height = list.get(stack.peek());
                    stack.pop();
                    int width = i - stack.peek() - 1;
                    res = Math.max(res, height * width);
                }
                stack.push(i);
            }
        }

        return res;
    }
}
