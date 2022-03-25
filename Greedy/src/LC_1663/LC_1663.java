package LC_1663;

import java.util.Arrays;

public class LC_1663 {
    public String getSmallestString(int n, int k) {

        int[] res = new int[n];
        Arrays.fill(res, 1);
        int sum = n;
        for (int i = n - 1; i >= 0; i--) {
            if (k - sum + 1 > 26) {
                res[i] = 26;
                sum += 25;
            } else {
                res[i] = k - sum + 1;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char) (res[i] - 1 + 'a'));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LC_1663 lc_1663 = new LC_1663();
        System.out.println(lc_1663.getSmallestString(3, 27));
    }
}
