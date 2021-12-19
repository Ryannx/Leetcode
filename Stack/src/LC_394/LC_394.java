package LC_394;

import java.util.Stack;

public class LC_394 {
    public String decodeString(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int i = 0;
        int sLen = s.length();
        while (i < sLen) {
            char curCh = s.charAt(i);
            if (curCh >= '0' && curCh <= '9') {
                int num = 0;
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                numStack.push(num);
            } else if (curCh == '[' || (curCh >= 'a' && curCh <= 'z')) {
                strStack.push(String.valueOf(curCh));
            } else {
                int num = 0;
                if (!numStack.isEmpty()) {
                    num = numStack.pop();
                }
                StringBuilder tempStr = new StringBuilder();
                while (!strStack.isEmpty() && !strStack.peek().equals("[")) {
                    tempStr.append(strStack.pop());
                }
                strStack.pop();

                StringBuilder temp = new StringBuilder();
                for (int k = 0; k < num; k++) {
                    temp.append(tempStr);
                }
                if (strStack.isEmpty()) {
                    res.append(temp.reverse());
                } else {
                    strStack.push(temp.toString());
                }
            }

            i++;
        }

        StringBuilder temp = new StringBuilder();
        while (!strStack.isEmpty()) {
            temp.append(strStack.pop());
        }
        res.append(temp.reverse());
        return res.toString();
    }
}
