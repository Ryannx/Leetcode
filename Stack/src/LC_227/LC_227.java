package LC_227;

import java.util.Stack;

public class LC_227 {
    public int calculate(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int strLen = s.length();
        int num = 0;
        char operation = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < strLen; i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                int j = i;
                while (j < strLen && Character.isDigit(s.charAt(j))) {
                    num = num * 10 + s.charAt(j) - '0';
                    j++;
                }
                i = j - 1;
            }
            if (i == strLen - 1 || !Character.isDigit(cur) && !Character.isWhitespace(cur)) {
                if (operation == '+') {
                    stack.push(num);
                } else if (operation == '-') {
                    stack.push(-num);
                } else if (operation == '*' && !stack.isEmpty()) {
                    stack.push(stack.pop() * num);
                } else if (operation == '/' && !stack.isEmpty()) {
                    stack.push(stack.pop() / num);
                }

                operation = cur;
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        LC_227 lc_227 = new LC_227();
        String s = " 3/2 ";
        System.out.println(lc_227.calculate(s));
    }
}
