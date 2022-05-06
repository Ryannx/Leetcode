package LC_1209;

import java.util.Stack;

public class LC_1209 {
    public String removeDuplicates(String s, int k) {

        if (s == null || s.length() == 0) {
            return "";
        }

        Stack<String> stack = new Stack<>();
        int i = s.length() - 1;
        int j = i;
        while (i >= 0 && j >= 0) {
            // already >= 3
            int count = 0;
            while (j >= 0 && s.charAt(i) == s.charAt(j)) {
                j--;
                count++;
                if (count == k) break;
            }
            if (count == k) {
                i = j;
                continue;
            }
            String next = s.substring(j + 1, i + 1);
            i = j;
            if (stack.isEmpty()) {
                stack.push(next);
                continue;
            }
            String cur = stack.peek();
            if (cur.charAt(0) == next.charAt(0)) {
                if (cur.length() + next.length() == k) {
                    stack.pop();
                } else if (cur.length() + next.length() > k){
                    stack.pop();
                    stack.push((cur + next).substring(0, cur.length() + next.length() - k));
                } else { // < k
                    stack.pop();
                    stack.push(next + cur);
                }
            } else {
                stack.push(next);
            }
        }

        if (stack.isEmpty()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LC_1209 lc_1209 = new LC_1209();
        String s = "jjjjjjiiiijjj";
        System.out.println(lc_1209.removeDuplicates(s, 4));
    }
}
