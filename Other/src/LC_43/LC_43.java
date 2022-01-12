package LC_43;

public class LC_43 {
    public String multiply(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder[] res = new StringBuilder[1];
        res[0] = new StringBuilder();
        res[0].append(0);
        for (int i = len1 - 1; i >= 0; i--) {
            StringBuilder temp = new StringBuilder();
            int updateDigit = 0;
            int cur1 = num1.charAt(i) - '0';
            int countZero = 0;
            if (cur1 == 0) {
                continue;
            }
            for (int j = len2 - 1; j >= 0; j--) {
                int cur2 = num2.charAt(j) - '0';
                int curMultiply = cur1 * cur2 + updateDigit;
                updateDigit = curMultiply / 10;
                temp.insert(0, curMultiply % 10);
                if (curMultiply % 10 == 0) {
                    countZero++;
                }
            }
            if (updateDigit != 0) {
                temp.insert(0, updateDigit);
            }
            // 当前结果是0直接跳过
            if (countZero == temp.length()) {
                continue;
            }
            // 补充偏移的0
            for (int k = i; k < len1 - 1; k++) {
                temp.append(0);
            }
            // add to last
            updateResult(res, temp);
        }

        return res[0].toString();
    }

    private void updateResult(StringBuilder[] res, StringBuilder temp) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int len1 = res[0].length();
        int len2 = temp.length();
        int updateDigit = 0;
        while (i < len1 && i < len2) {
            int idx1 = len1 - 1 - i;
            int idx2 = len2 - 1 - i;
            int cur1 = res[0].charAt(idx1) - '0';
            int cur2 = temp.charAt(idx2) - '0';
            int sum = cur1 + cur2 + updateDigit;
            sb.insert(0, sum % 10);
            updateDigit = sum / 10;
            i++;
        }

        if (updateDigit != 0) {
            if (len1 == len2) {
                sb.insert(0, updateDigit);
            } else if (len1 < len2) {
                while (i < len2) {
                    int idx = len2 - 1 - i;
                    int cur = temp.charAt(idx) - '0';
                    int sum = cur + updateDigit;
                    sb.insert(0, sum % 10);
                    updateDigit = sum / 10;
                    i++;
                }
                if (updateDigit != 0) {
                    sb.insert(0, updateDigit);
                }
            }
        } else {
            while (i < len2) {
                int idx = len2 - 1 - i;
                int cur = temp.charAt(idx) - '0';
                sb.insert(0, cur);
                i++;
            }
        }

        res[0] = sb;
    }

    public static void main(String[] args) {
        LC_43 lc_43 = new LC_43();
        System.out.println(lc_43.multiply("9133", "0"));
    }
}
