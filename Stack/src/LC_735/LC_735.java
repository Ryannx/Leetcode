package LC_735;

import java.util.*;

public class LC_735 {

    public int[] asteroidCollision(int[] asteroids) {

        if (asteroids == null || asteroids.length == 0) {
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            if (stack.isEmpty()) {
                stack.push(a);
            } else {
                if (stack.peek() < 0) {
                    stack.push(a);
                } else { // stack.peek > 0
                    if (a > 0) {
                        stack.push(a);
                        continue;
                    }
                    if (stack.peek() == -a) {
                        stack.pop();
                        continue;
                    }
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
                        stack.pop();
                    }
                    if (!stack.isEmpty() && stack.peek() == -a) {
                        stack.pop();
                        continue;
                    }
                    if (stack.isEmpty() || stack.peek() < 0) {
                        stack.push(a);
                    }
                }
            }
        }

        int len = stack.size();
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
