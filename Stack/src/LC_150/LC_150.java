package LC_150;

import java.util.*;

public class LC_150 {
    public int evalRPN(String[] tokens) {

        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (!isOperator(str)) {
                stack.push(Integer.parseInt(str));
            } else {
                if (stack.size() >= 2) {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    if (str.equals("+")) {
                        stack.push(num1 + num2);
                    } else if (str.equals("-")) {
                        stack.push(num1 - num2);
                    } else if (str.equals("*")) {
                        stack.push(num1 * num2);
                    } else {
                        stack.push(num1 / num2);
                    }
                }
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    public static void main(String[] args) {
        LC_150 lc_150 = new LC_150();
        String[] tokens = {"4","-2","/","2","-3","-","-"};
        System.out.println(lc_150.evalRPN(tokens));
    }
}
